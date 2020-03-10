package com.example.kotlininaction.javaAnonymousInnerClasses

fun main() {
//    ClassToTestListener().tryListener()

    val button = OuterClassButton()
    button.addOnButtonClickListener(
        object : OuterClassButton.ButtonClickListener {
            override fun buttonClicked(e: ClickEvent) {
                println("click")
            }
        }
    )

    val listener = object : OuterClassButton.ButtonClickListener{
        override fun buttonClicked(e: ClickEvent?) {
            println("another click")
        }
    }
    button.addOnButtonClickListener(listener)

    button.click()
}



