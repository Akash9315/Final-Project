package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Dietplan;
import com.sunbeam.entities.User;

public interface DietplanService {
	    Dietplan findById(int planid);
	    List<Dietplan>findAll();
	    Dietplan save(Dietplan dp);
	    Dietplan  update(Dietplan dp);
	    void deleteById(int planid);
}