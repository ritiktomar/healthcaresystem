package com.capgemini.hcm.dto;

import com.capgemini.hcm.entity.User;

import java.math.BigInteger;

/**
 * The type User dto.
 */
public class UserDTO {
    private String userName;
    private String userPassword;
    private String userRole;
    private BigInteger contactNumber;
    private String emailId;

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
     * Gets contact number.
     *
     * @return the contact number
     */
    public BigInteger getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets contact number.
     *
     * @param contactNumber the contact number
     */
    public void setContactNumber(BigInteger contactNumber) {
        this.contactNumber = contactNumber;
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
     * To user user.
     *
     * @return the user
     */
    public User toUser() {
        User user = new User();
        user.setUserName(this.getUserName());
        user.setEmailId(this.getEmailId());
        user.setContactNo(this.getContactNumber());
        user.setUserRole(this.getUserRole().isEmpty() ? "user" : this.getUserRole());
        user.setUserPassword(this.getUserPassword());
        return user;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                ", contactNumber=" + contactNumber +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
