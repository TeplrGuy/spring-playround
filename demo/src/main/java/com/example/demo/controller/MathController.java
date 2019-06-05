package com.example.demo.controller;

import com.example.demo.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
public class MathController {

    private final MathService mathService;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }
//
//    @GetMapping("/")
//    public String helloWorld() {
//        return "Hello from Spring!";
//    }
//
//    @GetMapping("/index")
//    public String index() {
//        return "This is index";
//    }

//    @GetMapping("/math/pi")
//    public String mathPi() {
//        return "3.141592653589793";
//    }

    @PostMapping("/math/calculate")
    public int calculate(WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        return mathService.calculate(params);
    }

    @PostMapping("/math/sum")
    public int sum(WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        return mathService.sum(params);
    }
}