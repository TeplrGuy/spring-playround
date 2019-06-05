package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WordCountService {

    public Map<String, Integer> count(String word) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        final String[] splitValues = word.split(" ");
        return  updateMap(stringIntegerMap, splitValues);
    }

    private  Map<String, Integer> updateMap(Map<String, Integer> stringIntegerMap,
                                            String[] splitValues) {
        for (String element:splitValues) {
            if (stringIntegerMap.containsKey(element)){
                stringIntegerMap.put(element, stringIntegerMap.get(element) + 1);
            }else {
                stringIntegerMap.put(element, 1);
            }
        }
        return stringIntegerMap;
    }
}
