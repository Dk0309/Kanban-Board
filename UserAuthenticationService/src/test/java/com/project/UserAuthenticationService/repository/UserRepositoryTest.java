package com.project.UserAuthenticationService.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.project.UserAuthenticationService.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE )
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	private User user;

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
		userRepository.deleteAll();
	}

	@Test
	public void givenUserToSaveShouldReturnPositiver()
	{
		userRepository.save(user);
		User user1 = userRepository.findById(user.getUserName()).get();
		assertEquals(user.getUserName(),user1.getUserName());
	}


}
