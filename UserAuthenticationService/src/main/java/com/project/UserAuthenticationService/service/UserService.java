package com.project.UserAuthenticationService.service;


import com.project.UserAuthenticationService.domain.User;
import com.project.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.project.UserAuthenticationService.exception.UserNotFoundException;

public interface UserService {
//    User saveUser(User user) throws UserAlreadyExistsException;
//    User findUserByEmailAndPassword(String email, String password) throws InvalidCredentials;

    public void initRoleAndUser() ;
    public User registerNewUser(User user) throws UserAlreadyExistsException;
    public String getEncodedPassword(String password);
    public void updateResetPasswordToken(String token, String email) throws UserNotFoundException;
}
