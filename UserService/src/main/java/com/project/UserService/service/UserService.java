package com.project.UserService.service;

import java.util.List;

import com.project.UserService.domain.User;
import com.project.UserService.exception.UserAlreadyExistsException;
import com.project.UserService.exception.UserNotFoundException;

public interface UserService {
	
	User saveUser(User user) throws UserAlreadyExistsException;
	User updateUser(User user,String email) throws UserNotFoundException;
	boolean deleteUser(String email) throws UserNotFoundException;
	List<User> getAllUsers();
	User getUserByEmail(String email) throws UserNotFoundException;

}
