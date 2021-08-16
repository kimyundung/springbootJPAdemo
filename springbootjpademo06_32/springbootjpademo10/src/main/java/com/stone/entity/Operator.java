package com.stone.entity;

public enum Operator {

    EQ("="),    // 等于
    LK(":"),    // like
    NE("!="),   // 不等于
    GT(">"),    // 大于
    LT("<"),    // 小于
    GE(">=");   // 大于等于

    private final String operator;
    Operator(String operator){
        this.operator = operator;
    }
    public static Operator fromOperator(String operator){
        for(Operator v: Operator.values()){
            if(v.operator.equalsIgnoreCase(operator)){
                return v;
            }
        }
        return null;
    }
}
