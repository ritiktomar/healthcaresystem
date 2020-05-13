package com.capgemini.hcm.service;

import com.capgemini.hcm.dao.AppointmentDao;
import com.capgemini.hcm.dao.DiagnosticCenterDao;
import com.capgemini.hcm.dao.TestDao;
import com.capgemini.hcm.dao.UserDao;
import com.capgemini.hcm.entity.Appointment;
import com.capgemini.hcm.entity.Tests;
import com.capgemini.hcm.entity.User;
import com.capgemini.hcm.exception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * The type User service.
 */
@Service
public class UserService {
    private final UserDao userDao;
    private final AppointmentDao appointmentDao;
    private final TestDao testDao;
    private final DiagnosticCenterDao centerDao;

    /**
     * Instantiates a new User service.
     *
     * @param dao            the dao
     * @param appointmentDao the appointment dao
     * @param testDao        the test dao
     * @param centerDao      the center dao
     */
    public UserService(UserDao dao, AppointmentDao appointmentDao, TestDao testDao, DiagnosticCenterDao centerDao) {
        this.userDao = dao;
        this.appointmentDao = appointmentDao;
        this.testDao = testDao;
        this.centerDao = centerDao;
    }

    /**
     * Save user user.
     *
     * @param user the user
     * @return the user
     */
    public User saveUser(User user) {
        return userDao.save(user);
    }

    /**
     * Save appointment.
     *
     * @param appointment the appointment
     */
    @Transactional(rollbackFor = CustomException.class)
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentDao.save(appointment);
    }

    /**
     * Find user by id user.
     *
     * @param id the id
     * @return the user
     */
    @Transactional(readOnly = true, rollbackFor = CustomException.class)
    public User findUserById(Integer id) {
        return userDao.findById(id).orElseThrow(() -> new CustomException("No such user exists!"));
    }

    /**
     * Find appointment by id appointment.
     *
     * @param id the id
     * @return the appointment
     */
    @Transactional(readOnly = true, rollbackFor = CustomException.class)
    public Appointment findAppointmentById(Integer id) {
        return appointmentDao.findById(id).orElseThrow(() -> new CustomException("Appointment does not exist!"));
    }

    /**
     * Find test by id tests.
     *
     * @param id the id
     * @return the tests
     */
    @Transactional(readOnly = true, rollbackFor = CustomException.class)
    public Tests findTestById(Integer id) {
        return testDao.findById(id).orElseThrow(() -> new CustomException("Test does not exist!"));
    }

    /**
     * Make appointment user.
     *
     * @param userId        the user id
     * @param appointmentId the appointment id
     * @param dateTime      the date time
     * @param testId        the test id
     * @return the user
     */
    @Transactional(rollbackFor = CustomException.class)
    public Appointment makeAppointment(Integer userId, Integer appointmentId, LocalDateTime dateTime, Integer testId) {
        User user = findUserById(userId);
        checkAndSave(appointmentId, testId, user);
        Appointment appointment = findAppointmentById(appointmentId);
        appointment.setUser(user);
        appointment.setAppointmentDateAndTime(dateTime);
        saveUser(user);
        return saveAppointment(appointment);
    }

    @Transactional(readOnly = true)
    public boolean checkStatusOfAppointment(Integer userId) {
        User user = findUserById(userId);
        Appointment appointment = findAppointmentById(user.getAppointmentId());
        return appointment.isApproved();
    }

    /**
     * Select center user.
     *
     * @param userId   the user id
     * @param centerId the center id
     * @return the user
     */
    @Transactional(rollbackFor = CustomException.class)
    public User selectCenter(Integer userId, Integer centerId) {
        User user = findUserById(userId);
        if (!centerDao.existsById(centerId))
            throw new CustomException("No such center exists!");
        user.setCenterId(centerId);
        return saveUser(user);
    }

    private void checkAndSave(Integer appointmentId, Integer testId, User user) {
        if (!appointmentDao.existsById(appointmentId))
            throw new CustomException("No such appointment exists!");
        user.setAppointmentId(appointmentId);
        if (!testDao.existsById(testId))
            throw new CustomException("No such test exists!");
        user.setTestId(testId);
    }

}
