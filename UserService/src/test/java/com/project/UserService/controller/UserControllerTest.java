package com.project.UserService.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.UserService.domain.User;
import com.project.UserService.exception.UserAlreadyExistsException;
import com.project.UserService.exception.UserNotFoundException;
import com.project.UserService.service.UserService;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	private User user , user1;
	
	@BeforeEach
	public void setUp()
	{
		user = new User("guptadk665@gmail.com","Deepak","1234");
		user1 = new User("demo@gmail","Demo","12345");
		List<User> users = Arrays.asList(user,user1);
		mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@AfterEach
	public void tearDown()
	{
		user = null;
		user1 = null;
	}
	
	@Test
	public void givenUserToSaveReturnSaveReturnSuccess() throws Exception, UserAlreadyExistsException
	{
		when(userService.saveUser(any())).thenReturn(user);
        mockMvc.perform(post("/api/v2/register")
                                .content(jsonToString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).saveUser(any());
	}
	
	
	@Test
    public void givenUserToSaveReturnSaveUserFailure() throws Exception, UserAlreadyExistsException
    {
        when(userService.saveUser(user)).thenThrow(UserAlreadyExistsException.class) ;
        mockMvc.perform(post("/api/v2/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(user)))
                .andExpect(status().is5xxServerError()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).saveUser(any());
    }
	
	
	
	private static String jsonToString(final Object o)throws JsonProcessingException
    {
        String result;
        try{
            ObjectMapper mapper= new ObjectMapper();
            String jsonContent=mapper.writeValueAsString(o);
            result=jsonContent;
        }
        catch(JsonProcessingException e)
        {
            result="JSON processing error";
        }
        return result;
    }
	
	@Test
    public void givenUserEmailDeleteUserSuccess() throws Exception, UserNotFoundException
    {
        when(userService.deleteUser(anyString())).thenReturn(true);
        mockMvc.perform(delete("/api/v2/deleteEmployee/guptadk665@gmail.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).deleteUser(anyString());
    }
	
	@Test
    public void givenUserEmailDeleteUserFailure() throws Exception, UserNotFoundException
    {
        when(userService.deleteUser(anyString())).thenReturn(false);
        mockMvc.perform(delete("/api/v2/deleteEmployee/guptadk665@gmail.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).deleteUser(anyString());
    }
	
	@Test
    public void givenUserEmailToFetchEmail() throws Exception, UserNotFoundException
    {
        when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
        mockMvc.perform(get("/api/v2/guptadk665@gmail.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).getUserByEmail(user.getEmail());
        }
}


