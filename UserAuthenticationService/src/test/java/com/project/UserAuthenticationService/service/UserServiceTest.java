package com.project.UserAuthenticationService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.project.UserAuthenticationService.domain.User;
import com.project.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.project.UserAuthenticationService.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	private User user;

	@InjectMocks
	public UserServiceImpl userService;


	@BeforeEach
	public void setUp()
	{
		user = new User();
		user.setUserName("Deepak");
		user.setPassword("1234");
	}

	@AfterEach
	public void tearDown()
	{
		user = null;
	}


	@Test
	public void givenUserToSaveReturnSaveUserSuccess() throws  UserAlreadyExistsException {
//		when(userRepository.findById(user.getUserName())).thenReturn(any());
//		when(userRepository.save(user)).thenReturn(user);
//		User user1 = userService.registerNewUser(user);
//		assertEquals(user,user1);
//		verify(userRepository,times(1)).save(user);
//		verify(userRepository,times(1)).findById(user.getUserName());
	}

	@Test
    public void givenUserToSaveReturnSaveUserFailure() {

//        when(userRepository.findById(user.getUserName())).thenReturn(Optional.ofNullable(user));
//        assertThrows(UserAlreadyExistsException.class,()->userService.registerNewUser(user));
//        verify(userRepository,times(0)).save(user);
//        verify(userRepository,times(1)).findById(user.getUserName());
    }




}
