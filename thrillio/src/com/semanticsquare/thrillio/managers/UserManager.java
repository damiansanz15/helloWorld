package com.semanticsquare.thrillio.managers;

import com.semanticsquare.thrillio.dao.UserDao;
import com.semanticsquare.thrillio.entities.User;

public class UserManager {
	
	private static UserManager instance = new UserManager();
	
	private static UserDao dao = new UserDao();
	
	
	private UserManager() {	}
	
	public static UserManager getInstance() {
		return instance;
	}
	
	public User createUser(long id, String email, String password, String firstName, String lastName, int gender, 
			String userType) {
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setGender(gender);
		user.setId(id);
		user.setLastName(lastName);
		user.setUserType(userType);
		user.setPassword(password);
		
		return user;
		
	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}
	

}
