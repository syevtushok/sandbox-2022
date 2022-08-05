package com.example;

import org.springframework.stereotype.Component;

import com.example.service.SimpleService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class BusinessLogic {
    private final SimpleService simpleService;

    public void doSomething() {
        simpleService.printMessage();
    }
}
