package io.pragra.learning.jpa2;

import io.pragra.learning.jpa2.domain.entity.Appointment;

import io.pragra.learning.jpa2.repo.ApptRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class Jpa2Application {

    private ApptRepo repo;

    public Jpa2Application(ApptRepo repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Jpa2Application.class, args);
    }


    //@Bean
    CommandLineRunner runner() {
        return args ->{
            Appointment appointment= Appointment.builder().firstName("harini").lastName("nishant")
                    .appointmentDate(Instant.now().plus(Duration.ofDays(2)))
                    .createDate(Instant.now()).updateDate(Instant.now()).doctorName("myatt").build();
            repo.save(appointment);
        };
    }
}