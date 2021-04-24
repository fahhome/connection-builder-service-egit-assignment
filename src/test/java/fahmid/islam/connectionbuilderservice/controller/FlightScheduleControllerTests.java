package fahmid.islam.connectionbuilderservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightScheduleControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
    }

    @Test
    public void mockTestController(){
        assertEquals(true, true);
    }

    @Test
    public void getFlightSchedules() throws JsonProcessingException, Exception {
        MvcResult result = mockMvc.perform(get("/connectionservice/flightSchedules").contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        
        assertEquals(200, result.getResponse().getStatus());
    }
    
}
