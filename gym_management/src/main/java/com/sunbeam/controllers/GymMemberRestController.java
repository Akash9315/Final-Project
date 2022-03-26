package com.sunbeam.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.GymMemberDTO;
import com.sunbeam.entities.GymMember;
import com.sunbeam.entities.User;
import com.sunbeam.services.GymMemberService;
import com.sunbeam.services.UserService;


@CrossOrigin
@RestController
public class GymMemberRestController {

	
	@Autowired
	private GymMemberService gymMemberService;
	
	
	   //get Gym Member  by memberId
		@GetMapping("/gymmembers/{memberId}")
		public ResponseEntity<?>findById(@PathVariable("memberId") int id) {
			Map<String,Object>map= new HashMap<>();
			GymMember gymmember = gymMemberService.findById(id);
			 map.put("status", "success");
			 map.put("data", gymmember);
			return ResponseEntity.ok(map);
		}
		
	
		
		//get all GymMembers
		@GetMapping("/gymmembers")
		public ResponseEntity<List<GymMember>> findAll() {
			List<GymMember> list = gymMemberService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		
	
	    //save or update GymMembers
		@PostMapping("/gymmembers/save")
		public ResponseEntity<GymMember> save(@RequestBody GymMember gm){
			System.out.println("insode gym meber");
		   //System.out.println(gm.toString());
			GymMember newUser = gymMemberService.save(gm);
		   return ResponseEntity.ok(newUser);
	   }
		
	 	//update GymMembers
		@PutMapping("/gymmembers/update/{memberId}")
		public ResponseEntity<GymMember> update(@PathVariable("memberId") int id,@RequestBody GymMember gm){
		   gm.setMemberId(id);
		   GymMember newUser = gymMemberService.update(gm);
		   return ResponseEntity.ok(newUser);
	   }
		  
		//delete GymMembers
		   @DeleteMapping("/gymmembers/delete/{memberId}")
			public void delete(@PathVariable("memberId") int id){
			   gymMemberService.deleteById(id);
		   }
		   
//		 	@PostMapping("/gymmemberdtos/save")
//		  	public ResponseEntity<?> save(GymMemberDTO dto) { // data input as form-data, so no @RequestBody
//		  		 System.out.println(dto.toString());
//		 		GymMember b = GymMemberDTO.toEntity(dto);
//		  		GymMember newGymMember = gymMemberService.save(b);
//		  		GymMemberDTO newDto = GymMemberDTO.fromEntity(newGymMember);
//		  		HashMap<String, Object> result = new HashMap<String, Object>();
//		  		result.put("status", "success");
//		  		result.put("data", newDto);
//		  		return ResponseEntity.ok(result);
//		  	}
}
