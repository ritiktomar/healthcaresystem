package com.capgemini.hcm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
    @SequenceGenerator(sequenceName = "doctor_seq", initialValue = 1010, allocationSize = 1, name = "doctor_seq")
    private Integer doctorId;

    @NotEmpty(message = "name is mandatory")
    @Column(name = "doctor_Name")
    private String doctorName;

    @NotNull(message = "contact must be mandatory")
    @Column(name = "doctor_contact")
    private BigInteger contactNumber;

    @NotEmpty(message = "doctorSpecialization is mandatory")
    @Column(name = "doctor_Specialization")
    private String doctorSpecialization;

    public Doctor(Integer doctorId, @NotEmpty(message = "name is mandatory") String doctorName,
                  @NotNull(message = "contact must be mandatory") @Size(max = 10, message = "number must be of 10 digit") BigInteger contactNumber,
                  @NotEmpty(message = "doctorSpecialization is mandatory") String doctorSpecialization) {
        super();
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.contactNumber = contactNumber;
        this.doctorSpecialization = doctorSpecialization;
    }

    public Doctor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public BigInteger getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(BigInteger contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", contactNumber=" + contactNumber
                + ", doctorSpecialization=" + doctorSpecialization + "]";
    }

}

