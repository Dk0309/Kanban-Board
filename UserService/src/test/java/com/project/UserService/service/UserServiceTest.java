package com.project.UserService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.project.UserService.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.UserService.domain.User;
import com.project.UserService.exception.UserAlreadyExistsException;
import com.project.UserService.exception.UserNotFoundException;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	private User user,user1;
	private List<User> users;
	
	
	@BeforeEach()
	public void setUp()
	{
		user = new User("guptadk665@gmail.com","Deepak","1234");
		user1 = new User("demo@gmail.com","Demo","12345");
		users = Arrays.asList(user,user1);
	}
	
	@AfterEach()
	public void tearDown()
	{
		user = null;
	}
	
	@Test
	public void givenUserToSaveUserShouldReturnSuccess() throws UserAlreadyExistsException
	{
		when(userRepository.findById(user.getEmail())).thenReturn(Optional.ofNullable(user));
				when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.saveUser(user));
        verify(userRepository,times(1)).findById(any());
        verify(userRepository,times(1)).save(any());
	}
	
	 @Test
	public void getAllUser() throws UserNotFoundException 
	 {
	     when(userRepository.findAll()).thenReturn(users);
	     assertEquals(2,userService.getAllUsers().size());
	     verify(userRepository,times(1)).findAll();
	 }
	 
	 @Test
	 public void givenUserToSaveShouldReturnFailure()
	 {
		 when(userRepository.findById(user.getEmail())).thenReturn(Optional.ofNullable(user));
	        assertThrows(UserAlreadyExistsException.class,()->userService.saveUser(user));
	        verify(userRepository,times(0)).save(any());
	        verify(userRepository,times(1)).findById(any());
	 }
	 
	 @Test
	 public void givenUserToDeleteShouldDeleteSuccess()throws UserNotFoundException
	  {
	        when(userRepository.findById(user.getEmail())).thenReturn(Optional.ofNullable(user));
	        boolean flag = userService.deleteUser(user.getEmail());
	        assertEquals(true,flag);
	        verify(userRepository,times(1)).deleteById(any());
	        verify(userRepository,times(1)).findById(any());

	  }
	 
	 @Test
	 public void givenUserToDeleteShouldDeletefailure() throws UserNotFoundException
	 {
	        when(userRepository.findById(user.getEmail())).thenReturn(Optional.ofNullable(user));
	        boolean flag=userService.deleteUser(user.getEmail());
	        assertNotEquals(false,flag);
	        verify(userRepository,times(1)).deleteById(any());
	        verify(userRepository,times(1)).findById(any());
	 }
	 
	
	 
}
