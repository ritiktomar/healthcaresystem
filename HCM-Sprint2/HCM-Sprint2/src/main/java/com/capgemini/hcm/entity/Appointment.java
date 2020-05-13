package com.capgemini.hcm.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Appointment_Details")
public class Appointment {
    @Id
    @Column(name = "appointment_Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @SequenceGenerator(sequenceName = "appointment_seq", initialValue = 1000, allocationSize = 1, name = "appointment_seq")
    private Integer appointmentId;

    @Column(name = "Appointment_DateAndTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentDateAndTime;

    @Column(name = "approved")
    private boolean approved;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
    private User user;

    public Appointment(Integer appointmentId, LocalDateTime appointmentDateAndTime, boolean approved, User user) {
        super();
        this.appointmentId = appointmentId;
        this.appointmentDateAndTime = appointmentDateAndTime;
        this.approved = approved;
        this.user = user;
    }

    public Appointment() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getAppointmentDateAndTime() {
        return appointmentDateAndTime;
    }

    public void setAppointmentDateAndTime(LocalDateTime appointmentDateAndTime) {
        this.appointmentDateAndTime = appointmentDateAndTime;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appointment [appointmentId=" + appointmentId + ", appointmentDateAndTime=" + appointmentDateAndTime
                + ", approved=" + approved + ", user=" + user + "]";
    }


}
