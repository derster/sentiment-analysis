package com.derster.sentiment.analysis;

public class MyFirstClass {
    private String myVar;
    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hell from class "+this.getClass().getSimpleName()+ " myVar=="+myVar;
    }
}
