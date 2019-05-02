package com.example.demo.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

    public void setUpRequestBuilderAndPerformMock(String returnValue, RequestBuilder requestBuilder) throws Exception{
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(returnValue));
    }

    @Test
    public void testIndexEndpoint() throws Exception {
       setUpRequestBuilderAndPerformMock("This is index", MockMvcRequestBuilders.get("/index"));
    }

    @Test
    public void mathEndpointShouldReturnPiValue() throws Exception {
        setUpRequestBuilderAndPerformMock("3.141592653589793", MockMvcRequestBuilders.get("/math/pi"));
    }

    @Test
    public void mathCalculateShouldReturnTheCorrectValue() throws Exception{
        setUpRequestBuilderAndPerformMock(
                "13", MockMvcRequestBuilders.post("/math/calculate?operation=subtract&x=20&x=3&y=8"));
    }
}
