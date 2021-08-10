package io.pragra.learning.jpa2.service;

import io.pragra.learning.jpa2.domain.StatusEnum;
import io.pragra.learning.jpa2.domain.entity.Appointment;
import io.pragra.learning.jpa2.repo.ApptRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AppointmentService {
    ApptRepo repo;

    public AppointmentService(ApptRepo repo) {
        this.repo = repo;
    }

    public Appointment createAppointment(Appointment appointment){

        if (appointment.getFirstName()== null){
            throw new IllegalArgumentException("First name cant be null");
        }
      appointment.setCreateDate(Instant.now());
        appointment.setUpdateDate(Instant.now());
        if ( appointment.getAppointmentDate().compareTo(Instant.now())==-1){
            throw new IllegalArgumentException("Incorrect Appointment");
        }
        appointment.setStatus(StatusEnum.ORIGINAL);
        repo.save(appointment);
        return appointment;
    }
    public Appointment updateAppointment(Appointment appointment){

//        if (appointment.getFirstName()== null){
//            throw new IllegalArgumentException("First name cant be null");
//        }
        appointment.setUpdateDate(Instant.now());
//        if ( appointment.getAppointmentDate().compareTo(Instant.now())==-1){
//            throw new IllegalArgumentException("appointment cannot be in the past");
//        }
        appointment.setStatus(StatusEnum.RESCHEDULED);
               return repo.save(appointment);
    }

    public Appointment getById(int id){

        if (id> 0){
            throw new IllegalArgumentException("Id cant be negative");
        }

        return repo.findById(id).orElseThrow(IllegalAccessError::new);
    }

    public List<Appointment> findAll() {
        return repo.findAll();
    }

    public List<Appointment> getAllForDoctorName(String name){
        return repo.findAllByDoctorName(name);
    }


}
