package com.sunbeam.services;

import java.util.List;


import com.sunbeam.entities.Workoutplan;

public interface WorkoutplanService {
	    Workoutplan findById(int workoutid);
	    List<Workoutplan>findAll();
	    Workoutplan save(Workoutplan wp);
	    Workoutplan  update(Workoutplan wp);
	    void deleteById(int workoutid );
}
