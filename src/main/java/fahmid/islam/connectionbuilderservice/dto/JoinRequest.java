package fahmid.islam.connectionbuilderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JoinRequest {
    
    private String fromAirport ;
    private String toAirport ;

    public String getFromAirport(){
        return this.fromAirport;
    }

    public String getToAirport(){
        return this.toAirport;
    }

}
