package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sunbeam.entities.Dietplan;


public interface DietplanDao  extends JpaRepository<Dietplan , Integer> {

}
