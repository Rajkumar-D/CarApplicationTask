package com.mytaxi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mytaxi.controller.CarController;
import com.mytaxi.service.car.DefaultCarService;

@RunWith(SpringRunner.class)

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

    @InjectMocks
    CarController carController;

    @Mock
    DefaultCarService carService;


    @Before
    public void setup()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(this.carController).build();
    }

    private static final String CAR_JSON =
        "{\"licensePlate\": \"TN-43-2130\",\"name\": \"Etios\",\"seatCount\": 4,\"rating\": 4,\"engineType\": \"\",\"color\": \"Yellow\",\"convertible\": true,\"manufacturerId\": 1}";


    @Test
    public void assertCreateCar() throws Exception
    {
        mockMvc.perform(post("/v1/cars")
            .content(CAR_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.ALL))
            .andExpect(status().isCreated())
            .andReturn();
    }


    @Test
    public void assertCreateUpdate() throws Exception
    {
        mockMvc.perform(put("/v1/cars/1")
            .content(CAR_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.ALL))
            .andExpect(status().isOk())
            .andReturn();
    }


    @Test
    public void getCarByID() throws Exception
    {

        mockMvc.perform(get("/v1/cars/1")
            .accept(MediaType.ALL))
            .andExpect(status().isOk());
    }


    @Test
    public void deleteCar() throws Exception
    {

        mockMvc.perform(get("/v1/cars/1")
            .accept(MediaType.ALL))
            .andExpect(status().isOk());
    }


    @Test
    public void retrieveAll() throws Exception
    {
        mockMvc.perform(get("/v1/cars?onlineStatus=ONLINE")
            .accept(MediaType.ALL))
            .andExpect(status().isOk());
    }

}
