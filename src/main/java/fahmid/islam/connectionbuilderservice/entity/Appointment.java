package fahmid.islam.connectionbuilderservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private int id;

    String status;
    String payment_status;
    
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    private Patient patient;
    
}
