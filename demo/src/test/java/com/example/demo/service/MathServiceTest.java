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

    private Map<String, String[]> setUp(String operation,
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
    @Test
    public void calculateAdditionShouldReturnTheRightValue()  {
        int returnValue = 30;
        Map<String, String[]> params = setUp("add", "10", "20", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }

    @Test
    public void calculateDivideShouldReturnTheRightValue()  {
        int returnValue = 5;
        Map<String, String[]> params = setUp("divide", "30", "6", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }


    @Test
    public void calculateMultiplyShouldReturnTheRightValue()  {
        int returnValue = 24;
        Map<String, String[]> params = setUp("multiply", "4", "6", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }

    @Test
    public void calculateSubtractShouldReturnTheRightValue()  {
        int returnValue = -2;
        Map<String, String[]> params = setUp("subtract", "4", "6", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }

    @Test
    public void calculateAddingWithoutOperationShouldReturnTheRightValue()  {
        int returnValue = 35;
        Map<String, String[]> params = setUp("", "30", "5", "x", "y");
        assertEquals("Found", returnValue, mathService.calculate(params));
    }


//    @Test
//    public void calculateSumShouldReturnTheRightValue()  {
//        int returnValue = 35;
//        Map<String, String[]> params = setUp("", "30", "5", "n", "n");
//        assertEquals("Found", returnValue, mathService.sum(params));
//    }


}
