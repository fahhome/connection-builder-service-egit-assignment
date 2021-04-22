package fahmid.islam.connectionbuilderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fahmid.islam.connectionbuilderservice.dao.*;
import fahmid.islam.connectionbuilderservice.dto.JoinResponse;
import fahmid.islam.connectionbuilderservice.entity.*;

//Lombok Boilerplate code is injected at compile time hance mvn clean install is success 

@Service
public class FlightScheduleService {
    @Autowired
    private FlightScheduleRepository flightScheduleRepository;

    public FlightSchedule createFlightSchedule(FlightSchedule flightSchedule) {
        return flightScheduleRepository.save(flightSchedule);
    }

    public List<FlightSchedule> createFlightSchedules(List<FlightSchedule> flightSchedules) {
        return flightScheduleRepository.saveAll(flightSchedules);
    }

    public FlightSchedule getFlightScheduleById(int id) {
        return flightScheduleRepository.findById(id).orElse(null);
    }

    public List<FlightSchedule> getFlightSchedules() {
        return flightScheduleRepository.findAll();
    }

    public List<JoinResponse> getConnectingFlights(){
        return flightScheduleRepository.getJoinInformation();
    }

    public FlightSchedule updateFlightSchedule(FlightSchedule flightSchedule) {
        FlightSchedule oldFlightSchedule = null;
        Optional<FlightSchedule> optionalflightSchedule = flightScheduleRepository.findById(flightSchedule.getId());
        if (optionalflightSchedule.isPresent()) {
            oldFlightSchedule = optionalflightSchedule.get();
            flightScheduleRepository.save(oldFlightSchedule);
        } else {
            return new FlightSchedule();
        }
        return oldFlightSchedule;
    }


    public String deleteFlightScheduleById(int id) {
        flightScheduleRepository.deleteById(id);
        return "FlightSchedule got deleted";
    }

}