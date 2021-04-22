package fahmid.islam.connectionbuilderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class JoinResponse {

    String onward_flight ; 
    String first_dep_airport ; 
    String first_arr_airport ; 
    String first_dep_time ;
    String first_arr_time;
    String connecting_flight;
    String second_dep_airport;
    String second_arr_airport;
    String second_dep_time;
    String second_arr_time;

    public JoinResponse(String onward_flight, String first_dep_airport, String first_arr_airport, String first_dep_time
     ,String first_arr_time, String connecting_flight, String second_dep_airport, String second_arr_airport, String second_dep_time, String second_arr_time){

        this.onward_flight = onward_flight;
        this.first_dep_airport = first_dep_airport;
        this.first_arr_airport = first_arr_airport;
        this.first_dep_time = first_dep_time;
        this.first_arr_time = first_arr_time;
        this.connecting_flight = connecting_flight;
        this.second_dep_airport = second_dep_airport;
        this.second_arr_airport = second_arr_airport;
        this.second_dep_time = second_dep_time;
        this.second_arr_time = second_arr_time;

    }
    
}
