package com.project.UserAuthenticationService.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.project.UserAuthenticationService.controller.UserController;
import com.project.UserAuthenticationService.domain.User;
import com.project.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.project.UserAuthenticationService.service.JwtServiceImpl;
import com.project.UserAuthenticationService.service.UserService;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@Mock
	private UserService userService;

	@Mock
	private JwtServiceImpl jwtService;

	@InjectMocks
	private UserController userController;

	private User user;

	@BeforeEach
	public void setUp()
	{
		 user = new User();
		 user.setUserName("Deepak");
		 user.setPassword("1234");
		 mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@AfterEach
	public void tearDown()
	{
		user = null;
	}

	@Test
	public void givenUserToSaveReturnSuccess() throws Exception, UserAlreadyExistsException, UserAlreadyExistsException {
//		when(userService.registerNewUser(user)).thenReturn(user);
//		mockMvc.perform(post("/registerNewUser").contentType(MediaType.APPLICATION_JSON).
//                content(jsonToString(user)))
//		.andExpect(status().isCreated())
//        .andDo(print());
//		verify(userService,times(1)).registerNewUser(any());
	}

	@Test
	public void givenUserToSaveReturnFailure() throws  Exception, UserAlreadyExistsException
	{
//		when(userService.registerNewUser(user)).thenThrow(UserAlreadyExistsException.class) ;
//		mockMvc.perform(post("/registerNewUser").contentType(MediaType.APPLICATION_JSON).
//                content(jsonToString(user)))
//		.andExpect(status().is5xxServerError()).andDo(MockMvcResultHandlers.print());
//		verify(userService,times(1)).registerNewUser(any());
	}

//	@Test
//	public void givenUserToLoginReturnSuccess() throws  JsonProcessingException, Exception, InvalidCredentials
//	{
//		when(jwtService.loadUserByEmail(user.getEmail())).thenReturn(user);
//		mockMvc.perform(post("/api/v1/login").contentType(MediaType.APPLICATION_JSON)
//		.content(jsonToString(user)))
//		.andExpect(status().is5xxServerError()).andDo(MockMvcResultHandlers.print());
//		verify(,times(1)).findUserByEmailAndPassword(user.getEmail(),user.getPassword());
//	}


    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(ob);
            result = jsonContent;
        } catch(JsonProcessingException e) {
            result = "JSON processing error";
        }

        return result;
    }
}
