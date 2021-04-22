package fahmid.islam.connectionbuilderservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlightSchedule {

    @Id
    @GeneratedValue
    private int id;

    String flightNo;
    String departure_airport;
    String arrival_airport;
    String departure_time;
    String arrival_time;

    
}
