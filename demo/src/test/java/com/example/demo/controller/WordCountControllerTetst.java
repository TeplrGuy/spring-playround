package com.example.demo.controller;

import com.example.demo.model.Sentence;
import com.example.demo.service.MathService;
import com.example.demo.service.WordCountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(MathController.class)
public class WordCountControllerTetst {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private WordCountService wordCountService;

    @InjectMocks
    private WordCountController wordCountController;


    @Before
    public void setup() {
        initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(wordCountController)
                .build();
    }

    /**
     *
     * @throws Exception
     * Helped with mockMvc
     * @https://howtodoinjava.com/spring-boot2/spring-boot-mockmvc-example/
     */
    @Test
    public void wordCountTest() throws Exception{
        Map<String, Integer> stringStringMap = new HashMap<>();
        stringStringMap.put("love", 2);
        stringStringMap.put("I", 1);
        stringStringMap.put("you", 2);
        Mockito.when(wordCountService.count(Mockito.any()))
                .thenReturn(stringStringMap);

        mockMvc.perform( MockMvcRequestBuilders
        .post("/words/count")
                .content(asJsonString(new Sentence().setSentence("I love to eat")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.love").exists());


    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
