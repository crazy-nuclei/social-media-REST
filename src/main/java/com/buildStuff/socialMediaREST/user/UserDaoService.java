package com.buildStuff.socialMediaREST.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount, "AA", LocalDate.now().minusYears(20) ));
		users.add(new User(++userCount, "AB", LocalDate.now().minusYears(21) ));
		users.add(new User(++userCount, "AC", LocalDate.now().minusYears(22) ));
	}
	
	public List<User> findAll(){
		return users;
	}
}