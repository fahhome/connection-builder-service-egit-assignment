package fahmid.islam.connectionbuilderservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fahmid.islam.connectionbuilderservice.dto.JoinResponse;
import fahmid.islam.connectionbuilderservice.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {


}
