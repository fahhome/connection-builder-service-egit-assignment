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
public class AppointmentService {
    @Autowired
    private AppointmentRepository AppointmentRepository;

    public Appointment createAppointment(Appointment Appointment) {
        return AppointmentRepository.save(Appointment);
    }

    public List<Appointment> createAppointments(List<Appointment> Appointments) {
        return AppointmentRepository.saveAll(Appointments);
    }

    public Appointment getAppointmentById(int id) {
        return AppointmentRepository.findById(id).orElse(null);
    }

    public List<Appointment> getAppointments() {
        return AppointmentRepository.findAll();
    }


    public Appointment updateAppointment(Appointment Appointment) {
        Appointment oldAppointment = null;
        Optional<Appointment> optionalAppointment = AppointmentRepository.findById(Appointment.getId());
        if (optionalAppointment.isPresent()) {
            oldAppointment = optionalAppointment.get();
            AppointmentRepository.save(oldAppointment);
        } else {
            return new Appointment();
        }
        return oldAppointment;
    }

    public String deleteAppointmentById(int id) {
        AppointmentRepository.deleteById(id);
        return "Appointment got deleted";
    }

}