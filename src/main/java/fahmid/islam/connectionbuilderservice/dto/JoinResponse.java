package fahmid.islam.connectionbuilderservice.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


    //The below two get functions are needed for the stream filter api to compile properly as it do not recognize lombok boiler-plate code
    public String getFirstDepAirport(){
        return this.first_dep_airport;
    }

    public String getSecondArrAirport(){
        return this.second_arr_airport;
    }
    

    public long getDifferenceOfCriticalTime() {
        long diff = 0;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = null;
        try {
            date1 = format.parse(this.first_arr_time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date date2 = null;
        try {
            date2 = format.parse(this.second_dep_time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long differenceInMilliSeconds = date2.getTime() - date1.getTime();

        System.out.println(differenceInMilliSeconds);

        diff = differenceInMilliSeconds/1000;
        diff = diff/3600 ;

        System.out.println(diff);

        return diff ;
    }
    
    
}
