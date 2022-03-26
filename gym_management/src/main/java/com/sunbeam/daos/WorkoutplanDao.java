package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sunbeam.entities.Workoutplan;

public interface WorkoutplanDao  extends JpaRepository<Workoutplan , Integer>{

}
