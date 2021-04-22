package fahmid.islam.connectionbuilderservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fahmid.islam.connectionbuilderservice.dto.JoinResponse;
import fahmid.islam.connectionbuilderservice.entity.FlightSchedule;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {

    @Query("SELECT new fahmid.islam.connectionbuilderservice.dto.JoinResponse(ff.flight_no,ff.departure_airport, ff.arrival_airport, ff.departure_time,ff.arrival_time , sf.flight_no , sf.departure_airport, sf.arrival_airport, sf.departure_time,sf.arrival_time  ) FROM FlightSchedule ff JOIN FlightSchedule sf ON ff.arrival_airport=sf.departure_airport")
    public List<JoinResponse> getJoinInformation();

}
