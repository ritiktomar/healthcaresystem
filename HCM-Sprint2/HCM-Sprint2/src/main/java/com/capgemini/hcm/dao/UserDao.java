package com.capgemini.hcm.dao;

import com.capgemini.hcm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
