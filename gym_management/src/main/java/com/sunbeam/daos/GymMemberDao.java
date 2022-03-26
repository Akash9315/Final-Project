package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.GymMember;
import com.sunbeam.entities.User;

public interface GymMemberDao extends JpaRepository<GymMember, Integer> {
 
	//GymMember findByEmail(String email);
	//List<GymMember> findByRole(String role);
}