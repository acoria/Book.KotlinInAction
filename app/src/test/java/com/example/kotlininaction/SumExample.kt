package com.example.kotlininaction

import java.lang.IllegalArgumentException

interface Expr

class Num(val value: Int) : Expr
class Sum(private val expr1: Expr, private val expr2: Expr) : Expr{

    val sum: Int

    init {
//        sum = evaluateExpr(expr1) + evaluateExpr(expr2)
        sum = evaluateExprTheKotlinWay(expr1) + evaluateExprTheKotlinWay(expr2)
    }

    fun evaluateExpr(expr: Expr) : Int{
        if(expr is Num){
            return expr.value
        }
        if(expr is Sum){
            return evaluateExpr(expr.expr1) + evaluateExpr(expr.expr2)
        }
        throw IllegalArgumentException()
    }

    fun evaluateExprTheKotlinWay(expr: Expr) : Int =
        when(expr){
            is Num -> {
                println("num: ${expr.value}")
                expr.value
            }
            is Sum -> {
                val leftExpr = evaluateExprTheKotlinWay(expr.expr1)
                val rightExpr = evaluateExprTheKotlinWay(expr.expr2)
                println("sum: $leftExpr + $rightExpr")
                leftExpr + rightExpr
            }
            else -> throw IllegalArgumentException()
        }

}
fun main(){
    println("Sum: ${Sum(Sum(Num(1), Num(2)), Num(4)).sum}")
}



