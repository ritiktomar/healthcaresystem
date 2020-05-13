package com.capgemini.hcm.controller;

import com.capgemini.hcm.dto.AppointmentRequestDTO;
import com.capgemini.hcm.dto.UserDTO;
import com.capgemini.hcm.response.Response;
import com.capgemini.hcm.response.ResponseModel;
import com.capgemini.hcm.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type User controller.
 */
@RestController("/user")
public class UserController {
    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param service the service
     */
    public UserController(UserService service) {
        userService = service;
    }

    /**
     * Save user response entity.
     *
     * @param userDTO the user dto
     * @return the response entity
     */
    @PostMapping("/saveUser")
    public ResponseEntity<Response> saveUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(ResponseModel.builder()
                    .message("Successfully saved!")
                    .status(1)
                    .object(userService.saveUser(userDTO.toUser()))
                    .build());
        } catch (Exception h) {
            return ResponseEntity.ok(ResponseModel.builder()
                    .message("Couldn't save!")
                    .object(null)
                    .status(0)
                    .build());
        }
    }

    /**
     * Make appointment response entity.
     * <p>
     * Needs appointmentId, userId, testId, localDate, localTime
     * Checks if id's are present in their tables.
     * If exists, then they are mapped to user
     *
     * @param requestDTO the request dto
     * @return the response entity
     */
    @PostMapping("/makeAppointment")
    public ResponseEntity<Response> makeAppointment(@RequestBody AppointmentRequestDTO requestDTO) {
        try {
            return ResponseEntity.ok(ResponseModel.builder()
                    .message("Successfully made appointment!")
                    .status(1)
                    .object(userService.makeAppointment(requestDTO.getUserId(), requestDTO.getAppointmentId(), requestDTO.getDateTime(), requestDTO.getTestId()))
                    .build());
        } catch (Exception h) {
            return ResponseEntity.ok(ResponseModel.builder()
                    .object(null)
                    .status(0)
                    .message("Couldn't make appointment!")
                    .build());
        }
    }

    /**
     * Select center response entity.
     * <p>
     * Requires centerId and userId.
     * Checks if centerId is present.
     * If exists, mapped to user
     *
     * @param userId   the user id
     * @param centerId the center id
     * @return the response entity
     */
    @PostMapping("/selectCenter/{userId}")
    public ResponseEntity<Response> selectCenter(@PathVariable Integer userId, @RequestParam Integer centerId) {
        try {
            return ResponseEntity.ok(ResponseModel.builder()
                    .message("Selected successfully!")
                    .status(1)
                    .object(userService.selectCenter(userId, centerId))
                    .build());
        } catch (Exception h) {
            return ResponseEntity.ok(ResponseModel.builder()
                    .message("Couldn't select")
                    .status(0)
                    .object(null)
                    .build());
        }
    }

    /**
     * Check status boolean.
     *
     * @param userId the user id
     * @return the boolean
     */
    @GetMapping("/checkStatus")
    public boolean checkStatus(@RequestParam Integer userId) {
        return userService.checkStatusOfAppointment(userId);
    }
}
