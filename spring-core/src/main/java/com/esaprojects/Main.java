package com.esaprojects;

import java.util.Arrays;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.esaprojects.component.CustomPrinter;
import com.esaprojects.component.Printer;

public class Main {
    private static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext("com.esaprojects");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        Printer printerCustom = context.getBean("printerCustom", Printer.class);
        Printer printerCustom2 = context.getBean("printerCustom", Printer.class);

        createCustomBeanDefinition(CustomPrinter.class);

        CustomPrinter customprinter = context.getBean(CustomPrinter.class);
    }

    static void createCustomBeanDefinition(Class<CustomPrinter> beanClass) {
        var customBeanDefinition = new GenericBeanDefinition();
        customBeanDefinition.setBeanClass(beanClass);
        var beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        beanFactory.registerBeanDefinition(beanClass.getName().toLowerCase(), customBeanDefinition);
    }
}
