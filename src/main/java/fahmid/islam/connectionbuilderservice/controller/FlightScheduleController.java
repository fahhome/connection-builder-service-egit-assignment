package fahmid.islam.connectionbuilderservice.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fahmid.islam.connectionbuilderservice.dto.JoinRequest;
import fahmid.islam.connectionbuilderservice.dto.JoinResponse;
import fahmid.islam.connectionbuilderservice.entity.*;
import fahmid.islam.connectionbuilderservice.service.*;

@RestController
@RequestMapping(value="/connectionservice")
@CrossOrigin
public class FlightScheduleController {
    @Autowired
    private FlightScheduleService flightScheduleService;

    @PostMapping("/addFlightSchedule")
    public FlightSchedule addFlightSchedule(@RequestBody FlightSchedule flightSchedule) {
        return flightScheduleService.createFlightSchedule(flightSchedule);
    }

    @PostMapping("/addFlightSchedules")
    public List<FlightSchedule> addFlightSchedules(@RequestBody List<FlightSchedule> flightSchedules) {
        return flightScheduleService.createFlightSchedules(flightSchedules);
    }

    @PostMapping("/connectingFlights")
    public List<JoinResponse> getConnectingFlights(@RequestBody JoinRequest joinRequest){

        List<JoinResponse> allConnectingFlights=  flightScheduleService.getConnectingFlights();
        List<JoinResponse> filteredConnectingFlights = new LinkedList<>();
        System.out.println("Filtering");

        allConnectingFlights.stream().filter(row -> row != null)
                                     .filter(row -> row.getFirstDepAirport().equals(joinRequest.getFromAirport()) && row.getSecondArrAirport().equals(joinRequest.getToAirport()))
                                     .filter(row -> row.getDifferenceOfCriticalTime() >= 2 && row.getDifferenceOfCriticalTime() <=8)
                                     .forEachOrdered(row -> filteredConnectingFlights.add(row));

        System.out.println("Filtering done");

        return filteredConnectingFlights;

    }

    @GetMapping("/flightSchedule/{id}")
    public FlightSchedule getFlightScheduleById(@PathVariable int id) {
        return flightScheduleService.getFlightScheduleById(id);
    }

    @GetMapping("/flightSchedules")
    public List<FlightSchedule> getAllFlightSchedules() {
        return flightScheduleService.getFlightSchedules();
    }

    @PutMapping("/updateflightSchedule")
    public FlightSchedule updateFlightSchedule(@RequestBody FlightSchedule flightSchedule) {
        return flightScheduleService.updateFlightSchedule(flightSchedule);
    }

    @DeleteMapping("/flightSchedule/{id}")
    public String deleteFlightSchedule(@PathVariable int id) {
        return flightScheduleService.deleteFlightScheduleById(id);
    }

}
