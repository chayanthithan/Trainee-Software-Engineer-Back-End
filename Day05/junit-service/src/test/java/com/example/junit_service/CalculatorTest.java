package com.example.junit_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    @InjectMocks
    Calculator calculator;

    @Test
    public void addTest(){
        double assertResult = calculator.add(10,20);
        assertEquals(assertResult,30);
    }

}