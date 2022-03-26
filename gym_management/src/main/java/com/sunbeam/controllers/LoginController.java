package com.sunbeam.controllers;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.User;
import com.sunbeam.models.Response;
import com.sunbeam.services.UserService;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired  
	private UserService userService;   
	
	
	
	  @PostMapping("/users/authenticateUser")
		public ResponseEntity<?> authenticateUser(User user,HttpSession session) {

			User authuser = userService.findByEmail(user.getEmail());

			
			if(authuser!=null && authuser.getRole().equals("admin") ){
				if(authuser.getPassword().equals(user.getPassword()) ){
					
					return Response.success(authuser);
				}
			}else if(authuser!=null && authuser.getRole().equals("trainer") ){
				if(authuser.getPassword().equals(user.getPassword()) ){
					
					return Response.success(authuser);
				}
			}else if(authuser!=null && authuser.getRole().equals("member") ){
				if(authuser.getPassword().equals(user.getPassword()) ){
					
					return Response.success(authuser);
				}
			}	
			return Response.error("404");
		}
	
}








