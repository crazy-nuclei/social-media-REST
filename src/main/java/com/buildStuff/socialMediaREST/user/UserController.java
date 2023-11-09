package com.buildStuff.socialMediaREST.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User new_user = userDaoService.addUser(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(new_user.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(new_user);
	}
}







