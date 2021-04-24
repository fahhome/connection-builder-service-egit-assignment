package fahmid.islam.connectionbuilderservice.controller;

import static org.junit.Assert.assertNotNull;
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

import fahmid.islam.connectionbuilderservice.dto.JoinRequest;
import fahmid.islam.connectionbuilderservice.dto.JoinResponse;
import fahmid.islam.connectionbuilderservice.entity.FlightSchedule;
import fahmid.islam.connectionbuilderservice.service.FlightScheduleService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightScheduleControllerTests {

    private MockMvc mockMvc;
    
    @Autowired
    private FlightScheduleService flightScheduleService;

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

    @Test
    public void testInternalCodesOfController(){

        JoinResponse jr1 = new JoinResponse("501", "BOM", "DXB", "4:30",
                "6:00", "201", "DXB", "JFK", "8:30",
                "14:30");
        JoinResponse jr2 = new JoinResponse("501", "BOM", "DXB", "4:30", "6:00", "211", "DXB", "IAH", "10:00", "17:00");


        JoinRequest joinRequest = new JoinRequest("BOM", "JFK");
        List<FlightSchedule> flightSchedules = flightScheduleService.getFlightSchedules();
        FlightSchedule flightSchedule = flightScheduleService.getFlightScheduleById(2);
        List<JoinResponse> allConnectingFlights = flightScheduleService.getConnectingFlights();
        List<JoinResponse> filteredConnectingFlights = new LinkedList<>();
        System.out.println("Filtering");
        
        

        allConnectingFlights.stream().filter(row -> row != null)
                .filter(row -> row.getFirstDepAirport().equals(joinRequest.getFromAirport())
                        && row.getSecondArrAirport().equals(joinRequest.getToAirport()))
                .filter(row -> row.getDifferenceOfCriticalTime() >= 2 && row.getDifferenceOfCriticalTime() <= 8)
                .forEachOrdered(row -> filteredConnectingFlights.add(row));


        // Test the getConnectingFlights Service



        assertNotNull(flightSchedules);
        assertNotNull(flightSchedule);
        assertNotNull(filteredConnectingFlights);
        assertEquals(true, allConnectingFlights.contains(jr1) || allConnectingFlights.contains(jr2) );


    }
    
}
