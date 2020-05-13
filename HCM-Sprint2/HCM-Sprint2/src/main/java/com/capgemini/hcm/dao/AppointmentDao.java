package com.capgemini.hcm.dao;

import com.capgemini.hcm.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDao extends JpaRepository<Appointment, Integer> {
}
