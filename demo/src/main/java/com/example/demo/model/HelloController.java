package com.example.demo.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @GetMapping("/index")
    public String index() {
        return "This is index";
    }

    @GetMapping("/math/pi")
    public String mathPi() {
        return "3.141592653589793";
    }

    /**
     *
     * @param webRequest
     * @return
     */
    @PostMapping("/math/calculate")
    public int calculate(WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        String[] operation = params.getOrDefault("operation", new String[]{});
        String[] x = params.getOrDefault("x", new String[]{"0"});
        String[] y = params.getOrDefault("y", new String[]{"0"});

        if(operation[0].equals("add")) {
           return Arrays.stream(parseIntArray(x)).sum() + Arrays.stream(parseIntArray(y)).sum();
        }
        if(operation[0].equals("subtract")) {
            return Arrays.stream(parseIntArray(x)).sum() - Arrays.stream(parseIntArray(y)).sum();
        }

        if(operation[0].equals("multiply")) {
            return Arrays.stream(parseIntArray(x)).sum() * Arrays.stream(parseIntArray(y)).sum();
        }

        if(operation[0].equals("divide")) {
            return Arrays.stream(parseIntArray(x)).sum() / Arrays.stream(parseIntArray(y)).sum();
        }

        return 0;
    }

    /**
     * Solution found on:
     * https://stackoverflow.com/questions/26313497/
     * whats-the-simplest-way-to-convert-a-string-array-to-an-int-array-using-java-8
     * @param arr
     * @return integer array
     */
    static int[] parseIntArray(String[] arr) {
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }

}