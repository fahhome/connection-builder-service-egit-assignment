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
public class PatientService {
    @Autowired
    private PatientRepository PatientRepository;

    public Patient createPatient(Patient Patient) {
        return PatientRepository.save(Patient);
    }

    public List<Patient> createPatients(List<Patient> Patients) {
        return PatientRepository.saveAll(Patients);
    }

    public Patient getPatientById(int id) {
        return PatientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatients() {
        return PatientRepository.findAll();
    }

    public Patient updatePatient(Patient Patient) {
        Patient oldPatient = null;
        Optional<Patient> optionalPatient = PatientRepository.findById(Patient.getId());
        if (optionalPatient.isPresent()) {
            oldPatient = optionalPatient.get();
            PatientRepository.save(oldPatient);
        } else {
            return new Patient();
        }
        return oldPatient;
    }

    public String deletePatientById(int id) {
        PatientRepository.deleteById(id);
        return "Patient got deleted";
    }

}