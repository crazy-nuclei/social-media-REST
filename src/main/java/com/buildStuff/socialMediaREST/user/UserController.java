package com.buildStuff.socialMediaREST.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserDaoService userDaoService;
	
	public UserController(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}
		
	@GetMapping("/users")
	public List<User> getAllUsers(){
			return userDaoService.findAll();
	}
	
	@GetMapping("users/{id}")
	public User getOneUser(@PathVariable int id) {
		return userDaoService.findOne(id);
	}
}

