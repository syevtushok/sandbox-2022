package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("com.example");
        var bean = context.getBean(BusinessLogic.class);
        bean.doSomething();
    }
}
