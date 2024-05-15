package com.ahmed.motos.service;

import com.ahmed.motos.entities.Role;
import com.ahmed.motos.entities.User;


public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}