package com.project.UserService.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.UserService.domain.User;
import com.project.UserService.exception.UserAlreadyExistsException;
import com.project.UserService.exception.UserNotFoundException;
import com.project.UserService.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2")
public class UserController {

	private UserService userService;
	private ResponseEntity<?> responseEntity;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException
	{
		//System.out.println("inside controller");
		try
		{
			User user1 = userService.saveUser(user);
			responseEntity = new ResponseEntity<>(user1,HttpStatus.CREATED);
		}
		catch(UserAlreadyExistsException e)
		{
			responseEntity = new ResponseEntity<>("User Already Exists",HttpStatus.CONFLICT);
		}
		catch(Exception ex)
		{
			responseEntity = new ResponseEntity<>("Please, Try Again Later",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	 
	@PutMapping("/updateEmployee/{email}")
	public ResponseEntity<?> updateEmployee(@RequestBody User user,@PathVariable String email) throws UserNotFoundException
	{
		System.out.println("inside  controller");
		try
		{
			User user1 = userService.updateUser(user,email);
			responseEntity = new ResponseEntity<>(user1,HttpStatus.CREATED);
		}
		catch(UserNotFoundException e)
		{
			responseEntity = new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
		}
		catch(Exception ex)
		{
			responseEntity = new ResponseEntity<>("Please, Try Again Later ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees()
	{
		try
		{
			responseEntity = new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			responseEntity = new ResponseEntity<>("Please, Try Again Later ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/deleteEmployee/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable String email) throws UserNotFoundException
	{
		try
		{
			responseEntity = new ResponseEntity<>(userService.deleteUser(email),HttpStatus.OK);
		}
		catch(UserNotFoundException e)
		{
			responseEntity = new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
		}
		catch(Exception ex)
		{
			responseEntity = new ResponseEntity<>("Please, Try Again Later ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email)
	{
		try
		{
			responseEntity = new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
		}
		catch(UserNotFoundException e)
		{
			responseEntity = new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
		}
		catch(Exception ex)
		{
			responseEntity = new ResponseEntity<>("Please, Try Again Later ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
}
