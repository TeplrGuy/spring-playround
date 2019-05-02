package com.example.demo.model;

import com.example.demo.service.MathService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MathService mathService;

    @InjectMocks
    private MathController mathController;

    @Before
    public void setup() {
        initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(mathController)
                .build();
    }

    public void setUpRequestBuilderAndPerformMock(String returnValue,
                                                  RequestBuilder requestBuilder,
                                                  ResultMatcher ok
                                                  ) throws Exception{

        Mockito.when(mathService.calculate(Mockito.any()))
                .thenReturn(Integer.parseInt(returnValue));

        this.mockMvc.perform(requestBuilder)
                .andExpect(ok)
                .andExpect(content().string(returnValue));
    }

//    @Test
//    public void testIndexEndpoint() throws Exception {
//       setUpRequestBuilderAndPerformMock("This is index",
//               MockMvcRequestBuilders.get("/index"), status().isOk());
//    }
//
//    @Test
//    public void mathEndpointShouldReturnPiValue() throws Exception {
//        setUpRequestBuilderAndPerformMock("3.141592653589793",
//                MockMvcRequestBuilders.get("/math/pi"), status().isOk());
//    }

    @Test
    public void mathCalculateSumShouldReturnTheCorrectValue() throws Exception{
        setUpRequestBuilderAndPerformMock(
                "31",
                MockMvcRequestBuilders.post("/math/calculate?operation=add&x=20&x=3&y=8"),
                status().isOk());
    }

    @Test
    public void mathCalculateSumShouldReturnTheCorrectValueWithoutOperation() throws Exception{
        setUpRequestBuilderAndPerformMock(
                "60",
                MockMvcRequestBuilders.post("/math/calculate?x=30&y=5"),
                status().isOk());
    }

    @Test
    public void mathCalculateSubtractShouldReturnTheCorrectValue() throws Exception{
        setUpRequestBuilderAndPerformMock(
                "-2",
                MockMvcRequestBuilders.post("/math/calculate?operation=subtract&x=0&x=4&y=6"),
                status().isOk());
    }

    @Test
    public void mathCalculateDivisionShouldReturnTheCorrectValue() throws Exception{
        setUpRequestBuilderAndPerformMock(
                "6",
                MockMvcRequestBuilders.post("/math/calculate?operation=divide&x=30&y=5"),
                status().isOk());
    }

    @Test
    public void mathCalculateMultiplyShouldReturnTheCorrectValue() throws Exception{
        setUpRequestBuilderAndPerformMock(
                "24",
                MockMvcRequestBuilders.post("/math/calculate?operation=multiply&x=4&y=6"),
                status().isOk());
    }

}
