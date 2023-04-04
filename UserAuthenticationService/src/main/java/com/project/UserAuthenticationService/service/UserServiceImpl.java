package com.project.UserAuthenticationService.service;


import com.project.UserAuthenticationService.domain.Role;
import com.project.UserAuthenticationService.domain.User;
import com.project.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.project.UserAuthenticationService.exception.UserNotFoundException;
import com.project.UserAuthenticationService.repository.RoleRepository;
import com.project.UserAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {this.userRepository = userRepository;}

    @Override
    public void initRoleAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setPassword(getEncodedPassword("admin@pass"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

    @Override
    public User registerNewUser(User user) throws UserAlreadyExistsException {
        Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setPassword(getEncodedPassword(user.getPassword()));

        if(userRepository.findById(user.getUserName()).isPresent())
        {
	       throw new UserAlreadyExistsException();
        }

        return userRepository.save(user);
    }

    @Override
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }


//    @Override
//    public User saveUser(User user) throws UserAlreadyExistsException {
//
//    	if(userRepository.findById(user.getEmail()).isPresent())
//        {
//	       throw new UserAlreadyExistsException();
//        }
//
//        return userRepository.save(user);
//
//    }
//
//
//    @Override
//    public User findUserByEmailAndPassword(String email, String password) throws InvalidCredentials {
//        User user = userRepository.findUserByEmailAndPassword(email, password);
//        if(user==null)
//        {
//        	throw new InvalidCredentials();
//        }
//
//        return user;
//    }

    public void updateResetPasswordToken(String token, String email) throws UserNotFoundException{
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new UserNotFoundException("Could not find any user with the email " + email);
        }
    }
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
}
