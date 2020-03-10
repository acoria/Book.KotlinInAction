package com.example.kotlininaction

interface Context
class AttributeSet(style: String)
open class View{
    constructor(ctx: Context){
        //some code
    }
    constructor(ctx: Context, attr: AttributeSet){
        //some other code
    }
}

class MyButton: View{
    constructor(ctx: Context): super(ctx){
        //do whatever needs to be done
    }
    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr)

    constructor(ctx: Context, style: String): this(ctx, AttributeSet(style)){
        val myStyle = style
    }
}
