package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Plan;
import com.sunbeam.entities.User;


public interface PlanDao extends JpaRepository<Plan , Integer> {
	//User findByEmail(String email);
	//List<User> findByRole(String role);
}
