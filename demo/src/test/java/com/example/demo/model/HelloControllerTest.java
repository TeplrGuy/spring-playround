package com.example.demo.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public void setUpRequestBuilder(String path, String returnValue) throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(path);
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(returnValue));
    }

    @Test
    public void testIndexEndpoint() throws Exception {
       setUpRequestBuilder("/index", "This is index");
    }

    @Test
    public void mathEndpointShouldReturnPiValue() throws Exception {
        setUpRequestBuilder("/math/pi", "3.141592653589793");
    }
}
