package com.capgemini.hcm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigInteger;

/**
 * The type User.
 */
@Entity
@Table(name = "User_Table")
public class User {
    @Id
    @Column(name = "user_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = "user password is mandatory")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$")
    @Column(name = "userPassword")
    private String userPassword;

    @NotEmpty(message = "user name is mandatory")
    @Column(name = "userName")
    private String userName;

    @NotNull(message = "contact must be mandatory")
    @Column(name = "contactNo")
    private BigInteger contactNo;

    @Column(name = "userRole")
    private String userRole;

    @NotEmpty(message = "emailid is mandatory")
    @Column(name = "emailId")
    private String emailId;

    private Integer appointmentId;

    private Integer testId;

    private Integer centerId;

    /**
     * Instantiates a new User.
     *
     * @param userId       the user id
     * @param userPassword the user password
     * @param userName     the user name
     * @param contactNo    the contact no
     * @param userRole     the user role
     * @param emailId      the email id
     */
    public User(Integer userId,
                @NotEmpty(message = "user password is mandatory") @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$") String userPassword,
                @NotEmpty(message = "user name is mandatory") String userName,
                @NotNull(message = "contact must be mandatory") @Size(max = 10, message = "number must be of 10 digit") BigInteger contactNo,
                String userRole, @NotEmpty(message = "emailid is mandatory") String emailId) {
        super();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.contactNo = contactNo;
        this.userRole = userRole;
        this.emailId = emailId;
    }

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets user password.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets contact no.
     *
     * @return the contact no
     */
    public BigInteger getContactNo() {
        return contactNo;
    }

    /**
     * Sets contact no.
     *
     * @param contactNo the contact no
     */
    public void setContactNo(BigInteger contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * Gets user role.
     *
     * @return the user role
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets user role.
     *
     * @param userRole the user role
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * Gets email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets email id.
     *
     * @param emailId the email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets appointment id.
     *
     * @return the appointment id
     */
    public Integer getAppointmentId() {
        return appointmentId;
    }

    /**
     * Sets appointment id.
     *
     * @param appointmentId the appointment id
     */
    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * Gets test id.
     *
     * @return the test id
     */
    public Integer getTestId() {
        return testId;
    }

    /**
     * Sets test id.
     *
     * @param testId the test id
     */
    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    /**
     * Gets center id.
     *
     * @return the center id
     */
    public Integer getCenterId() {
        return centerId;
    }

    /**
     * Sets center id.
     *
     * @param centerId the center id
     */
    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", contactNo=" + contactNo +
                ", userRole='" + userRole + '\'' +
                ", emailId='" + emailId + '\'' +
                ", appointmentId=" + appointmentId +
                ", testId=" + testId +
                ", centerId=" + centerId +
                '}';
    }

}
