package fahmid.islam.connectionbuilderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fahmid.islam.connectionbuilderservice.entity.FlightSchedule;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {

}
