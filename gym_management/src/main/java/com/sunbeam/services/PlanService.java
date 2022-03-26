package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Plan;
import com.sunbeam.entities.User;

public interface PlanService {
	    Plan findById(int subplanId);
	    List<Plan>findAll();
	    Plan save(Plan pl);
	    Plan update(Plan pl);
	    void deleteById(int subplanId);
	  //  public Plan authenticate(String email, String password);
	  // Plan findByEmail(String email);
	  //	List<Plan> findByRole(String role) ;
}
