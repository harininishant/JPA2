package io.pragra.learning.jpa2.controller;

import io.pragra.learning.jpa2.domain.entity.Appointment;
import io.pragra.learning.jpa2.repo.ApptRepo;
import io.pragra.learning.jpa2.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

        private AppointmentService service;//injecting the interface that implements JPA

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/appointment/all")
        public List<Appointment> getAllAppointment(){
            return service.findAll();
        }

    @GetMapping("/appointment/{id}")
    public Appointment getById(@PathVariable int id){
        return service.getById(id);
    }


        @PostMapping("/appointment")// updating single appointment
        public  Appointment createAppointment(@RequestBody Appointment appointment){
            return this.service.createAppointment(appointment);// save methos will save in database
        }
      @GetMapping("/appointment/doctor/{doctorname}")
        public List<Appointment> getAllForDoctorName(@PathVariable String doctorname){
        return service.getAllForDoctorName(doctorname);
    }

    @PostMapping("/appointment/update")
    public Appointment updateAppointment(@RequestBody Appointment appointment){
        return service.updateAppointment(appointment);
    }

}
