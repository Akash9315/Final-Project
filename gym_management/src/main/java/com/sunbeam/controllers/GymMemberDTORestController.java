package com.sunbeam.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.GymMemberDTO;
import com.sunbeam.entities.GymMember;
import com.sunbeam.entities.Plan;
import com.sunbeam.entities.User;
import com.sunbeam.models.Response;
import com.sunbeam.services.GymMemberService;
import com.sunbeam.services.PlanService;
import com.sunbeam.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/gym")
public class GymMemberDTORestController {

	@Autowired
	private GymMemberService gymMemberService;

	@Autowired
	private UserService userService;

	@Autowired
	private PlanService planService;
//	      @GetMapping("/gymmembers")
//	  	public ResponseEntity<?> findById(@PathVariable("id") int id) {
//	  		Book b =  bookService.findById(id);
//	  		return ResponseEntity.ok(BookDTO.fromEntity(b));
//	  	}

	@PostMapping("/gymmemberdtos")
	public ResponseEntity<?> saveDetails(GymMemberDTO dto){ // data input as form-data, so no
																			// @RequestBody
		System.out.println("inside DTO");
		System.out.println(dto.toString());
		User u = userService.findById(dto.getUser_id());
		System.out.println("user: " + u.toString());

		Plan p = planService.findById(dto.getSubplanId());
		System.out.println("plan: " + p.toString());

		GymMember b = GymMemberDTO.toEntity(dto);
		System.out.println("gymmember :" + b.toString());
		b.setUser(u);
		b.setPlan(p);
		b.setJoinDate(new Date());
		// b = gymMemberservice.save(b);
		GymMember newGymMember = gymMemberService.save(b);

		GymMemberDTO newDto = GymMemberDTO.fromEntity(newGymMember);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("status", "success");
		result.put("data", newDto);
		return ResponseEntity.ok(result);
		// return Response.success(b);

	}

}
