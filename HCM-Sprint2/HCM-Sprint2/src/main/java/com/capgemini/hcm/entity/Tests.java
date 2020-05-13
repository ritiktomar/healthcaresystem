package com.capgemini.hcm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Test_table")
public class Tests {
    @Id
    @Column(name = "test_Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
    @SequenceGenerator(sequenceName = "test_seq", initialValue = 1, allocationSize = 1, name = "test_seq")
    private Integer testId;

    @Column(name = "testName")
    private String testName;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Doctor.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "test_Id", referencedColumnName = "test_Id")
    private List<Doctor> doctorlist;


    public Tests(Integer testId, String testName, List<Doctor> doctorlist) {
        super();
        this.testId = testId;
        this.testName = testName;
        this.doctorlist = doctorlist;
    }


    public Tests() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public List<Doctor> getDoctorlist() {
        return doctorlist;
    }

    public void setDoctorlist(List<Doctor> doctorlist) {
        this.doctorlist = doctorlist;
    }

    @Override
    public String toString() {
        return "Tests [testId=" + testId + ", testName=" + testName + ", doctorlist=" + doctorlist + "]";
    }

}
