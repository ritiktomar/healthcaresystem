package com.capgemini.hcm.dao;

import com.capgemini.hcm.entity.Tests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<Tests, Integer> {
}
