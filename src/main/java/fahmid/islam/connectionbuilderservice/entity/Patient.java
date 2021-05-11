package fahmid.islam.connectionbuilderservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    
    @Id
    @GeneratedValue
    private int id;

    String first_name;
    String last_name;
    String mobile_no;
    String email ;
    
    @OneToMany(mappedBy = "patient",  fetch = FetchType.EAGER)
    private List<Appointment> appointments;

}
