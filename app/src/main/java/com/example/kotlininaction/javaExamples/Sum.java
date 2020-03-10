package com.example.kotlininaction.javaExamples;

public class Sum implements IExpr {

    int sum;
    IExpr expr1;
    IExpr expr2;

    public Sum(IExpr expr1, IExpr expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
        sum();
    }

    private void sum() {
        sum = evaluateExpression(expr1) + evaluateExpression(expr2);
    }

    private int evaluateExpression(IExpr expr) {
        if(expr instanceof Num){
            return ((Num) expr).value;
        }
        if(expr instanceof Sum){
            return evaluateExpression(((Sum) expr).expr1) + evaluateExpression(((Sum) expr).expr2);
        }
        throw new IllegalArgumentException();
    }

    public int getSum(){
        return sum;
    }
}
