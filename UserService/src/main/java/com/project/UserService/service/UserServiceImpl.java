package com.project.UserService.service;

import java.util.List;

import com.project.UserService.proxy.UserProxy;
import com.project.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.project.UserService.config.Producer;
import com.project.UserService.domain.User;
import com.project.UserService.exception.UserAlreadyExistsException;
import com.project.UserService.exception.UserNotFoundException;
//import com.project.rabbitMQ.domain.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	private UserProxy userProxy;

//	@Autowired
//	private Producer producer;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,UserProxy userProxy) {
		super();
		this.userRepository = userRepository;
		this.userProxy = userProxy;
	}

	@Override
	public User saveUser(User user) throws UserAlreadyExistsException {
		User user1 = null;
		//System.out.println("inside Services");
//		UserDTO userDTO = new UserDTO();
//		userDTO.setEmail(user.getEmail());
//		userDTO.setUserName(user.getUserName());
//		userDTO.setPassword(user.getPassword());
		if(userRepository.findById(user.getEmail()).isPresent())
		{
			throw new UserAlreadyExistsException();
		}
		//System.out.println("user " + user);
//		System.out.println("saved customer in mongo");
//		producer.sendMessageToRabbitMQ(userDTO);
		try {
			ResponseEntity<?> r = userProxy.registerNewUser(user);
			System.out.println(r.getBody());
			 user1 = userRepository.save(user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user1;
	}  

	@Override
	public User updateUser(User user,String email) throws UserNotFoundException {
		//System.out.println("inside Services");
		if(userRepository.findById(email).isEmpty())
		{
			throw new UserNotFoundException();
		}
		
		return  userRepository.save(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUser(String email) throws UserNotFoundException {
		if(userRepository.findById(email).isEmpty())
		{
			throw new UserNotFoundException();
		}
		
		userRepository.deleteById(email);
		return true;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		if(userRepository.findById(email).isEmpty())
		{
			throw new UserNotFoundException();
		}
		return userRepository.getUserByEmail(email);
	}

}
