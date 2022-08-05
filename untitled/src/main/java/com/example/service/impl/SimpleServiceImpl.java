package com.example.service.impl;

import org.springframework.stereotype.Service;

import com.example.service.SimpleService;

@Service
public class SimpleServiceImpl implements SimpleService {
    @Override
    public void printMessage() {
        System.out.println("message");
    }
}
