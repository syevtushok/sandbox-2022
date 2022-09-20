package com.esaprojects.component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Printer {

    @Bean
    public void print() {
        System.out.println("Print....");
    }

    @Bean(name = "printerCustom")
    @Scope(value = SCOPE_PROTOTYPE)
    public Printer getInstance() {
        System.out.println("creating...");
        return new Printer();
    }
}
