package com.project.UserService.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.UserService.domain.User;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	private User user;
	
	@BeforeEach
	public void setUp()
	{
		user = new User("guptadk665@gmail.com","Deepak","1234");
	}
	
	@AfterEach
	public void tearDown()
	{
		user = null;
		userRepository.deleteAll();
	}
	
	
	@Test
	public void givenUserToSaveUserShouldReturnSuccess()
	{
		userRepository.insert(user);
		User user1 = userRepository.findById(user.getEmail()).get();
		assertEquals(user.getEmail(),user1.getEmail());
		
	}
	
	
	@Test 
	public void givenUserToDeleteShouldDeleteReturnSuccess()
	{
		 userRepository.insert(user);
	     User user1 = userRepository.findById(user.getEmail()).get();
	     userRepository.delete(user1);
	     assertEquals(Optional.empty(),userRepository.findById(user.getEmail()));
	}
	
	@Test
	public void returnAllUserShouldReturnSuccess()
	{
		userRepository.insert(user);
        User user1 = new User("demo@gmail.com","Demo","12345");
        userRepository.insert(user1);
        List<User> list=userRepository.findAll();
        assertEquals(2,list.size());
        assertEquals("Demo",list.get(1).getUserName());
	}
	
	 @Test
	 public void givenUserNotEqualToExpectedResult()
	    {
	         userRepository.insert(user);
	         List<User> list = userRepository.findAll();
	         assertNotEquals(2,list.size());
	    }
	
	 @Test
	 public void givenUserToDeleteShouldDeleteReturnFailure()
	 {
		    userRepository.insert(user);
	        User user1 = userRepository.findById(user.getEmail()).get();
	        userRepository.delete(user1);
	        userRepository.insert(user);
	        User user2 = userRepository.findById(user.getEmail()).get();
	        assertNotEquals(Optional.empty(),userRepository.findById(user.getEmail()));
	 }
	 
	 @Test
	 public void givenUserToGetUserShouldReturnSuccess()
	 {
		 userRepository.insert(user);
		 User user1 = userRepository.getUserByEmail(user.getEmail());
		 assertEquals(user.getEmail(),user1.getEmail());
	 }
}
