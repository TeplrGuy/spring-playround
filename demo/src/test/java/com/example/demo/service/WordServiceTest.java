package com.example.demo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WordServiceTest {

    @Autowired
    private WordCountService wordCountService;

    @Test
    public void TestWordCount(){
        Map<String, Integer> setOfWords = wordCountService.count("How now, brown cow");
        Map<String, Integer> words = wordCountService.count("A brown cow jumps over a brown fox");
        //Assert.assertEquals(setOfWords.toString(), "" );
        Assert.assertEquals(words.toString(), "" );


    }
}
