package io.pragra.learning.jpa2.repo;

import io.pragra.learning.jpa2.domain.entity.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApptRepo  extends JpaRepository<Appointment,Integer> {
     List<Appointment> findAllByDoctorName(String name);

}
