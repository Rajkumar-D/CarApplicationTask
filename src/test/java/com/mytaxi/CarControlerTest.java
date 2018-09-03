package com.mytaxi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mytaxi.controller.CarController;
import com.mytaxi.service.car.CarService;



@RunWith(SpringRunner.class)
//@WebMvcTest(CarController.class)
//@Configuration
@ComponentScan("com.mytaxi.*")
@EnableJpaRepositories(basePackages = {"com.mytaxi.*"})
@EntityScan("com.mytaxi.*")
@EnableAutoConfiguration
@SpringBootTest
@AutoConfigureMockMvc


public class CarControlerTest
{

    @Autowired 
    private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext wac;
    
    @Autowired
    CarController carController;
    
   
    
    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }
    
    private static final String CAR_JSON="{\"licensePlate\": \"TN-43-2130\",\"name\": \"Etios\",\"seatCount\": 4,\"rating\": 4,\"engineType\": \"\",\"color\": \"Yellow\",\"convertible\": true\"manufacturerId\": 1}";
    
   // @Test
    public void assertCreateCar() throws Exception {
        mockMvc.perform(post("v1/cars")
            .content(CAR_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.ALL))
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test
    public void retrieveAll() throws Exception {
    
        mockMvc.perform(get("v1/cars")
                   .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk());
    }
    
}
