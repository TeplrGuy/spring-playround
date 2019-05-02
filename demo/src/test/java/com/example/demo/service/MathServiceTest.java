package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MathServiceTest {

    @Autowired
    private MathService mathService;

    private Map<String, String[]> setUpForOperationCalculation(String operation,
                                        String xValue,
                                        String yValue,
                                        String x,
                                        String y){
        Map<String, String[]> params = new HashMap<>();
        params.put("operation", new String[]{operation});
        params.put(x, new String[]{xValue});
        params.put(y, new String[]{yValue});
        return params;
    }

    private Map<String, String[]> setUpForSumCalulation(String[] n){
        Map<String, String[]> params = new HashMap<>();
        params.put("n", n);
        return params;
    }
    @Test
    public void calculateAdditionShouldReturnTheRightValue()  {
        int returnValue = 30;
        Map<String, String[]> params = setUpForOperationCalculation("add", "10", "20", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }

    @Test
    public void calculateDivideShouldReturnTheRightValue()  {
        int returnValue = 5;
        Map<String, String[]> params = setUpForOperationCalculation("divide", "30", "6", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }


    @Test
    public void calculateMultiplyShouldReturnTheRightValue()  {
        int returnValue = 24;
        Map<String, String[]> params = setUpForOperationCalculation("multiply", "4", "6", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }

    @Test
    public void calculateSubtractShouldReturnTheRightValue()  {
        int returnValue = -2;
        Map<String, String[]> params = setUpForOperationCalculation("subtract", "4", "6", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }

    @Test
    public void calculateAddingWithoutOperationShouldReturnTheRightValue()  {
        int returnValue = 35;
        Map<String, String[]> params = setUpForOperationCalculation("", "30", "5", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }


    @Test
    public void calculateSumShouldReturnTheRightValue()  {
        int returnValue = 36;
        String[] n = {"30", "5", "1"};
        Map<String, String[]> params = setUpForSumCalulation(n);
        assertEquals("Found", returnValue, mathService.sum(params));
    }


}
