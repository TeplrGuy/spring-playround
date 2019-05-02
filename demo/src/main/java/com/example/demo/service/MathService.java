package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class MathService {

    /**
     * Calculate the sum, subtracting, multiplication, and division
     * given a x and y value taken in as a parameter
     * @param params
     * @return the correct value after operatation
     */
    public int calculate(Map<String, String[]> params){
        String[] operation = params.getOrDefault("operation", new String[]{});
        String[] x = params.getOrDefault("x", new String[]{"0"});
        String[] y = params.getOrDefault("y", new String[]{"0"});

        if(operation[0].equals("add") || operation[0].isEmpty())
            return Arrays.stream(parseIntArray(x)).sum() + Arrays.stream(parseIntArray(y)).sum();

        if(operation[0].equals("subtract"))
            return Arrays.stream(parseIntArray(x)).sum() - Arrays.stream(parseIntArray(y)).sum();

        if(operation[0].equals("multiply"))
            return Arrays.stream(parseIntArray(x)).sum() * Arrays.stream(parseIntArray(y)).sum();

        if(operation[0].equals("divide"))
            return Arrays.stream(parseIntArray(x)).sum() / Arrays.stream(parseIntArray(y)).sum();
        return 0;
    }

//    public int sum(Map<String, String[]> params) {
//        String[] n = params.getOrDefault("n", new String[]{"0"});
//        return Arrays.stream(parseIntArray(n)).sum();
//    }


    /**
     * Solution found on:
     * https://stackoverflow.com/questions/26313497/
     * whats-the-simplest-way-to-convert-a-string-array-to-an-int-array-using-java-8
     *
     * Converts a string array into integer array
     * @param arr
     * @return integer array
     */
    private static int[] parseIntArray(String[] arr) {
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }


}
