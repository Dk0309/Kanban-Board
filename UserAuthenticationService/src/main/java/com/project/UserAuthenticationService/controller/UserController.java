package com.project.UserAuthenticationService.controller;

import com.project.UserAuthenticationService.domain.User;
import com.project.UserAuthenticationService.exception.UserAlreadyExistsException;

//import com.project.token.SecurityTokenGenerator;
import com.project.UserAuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private UserService userService;
    private ResponseEntity responseEntity;
//    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
//        this.securityTokenGenerator = securityTokenGenerator;
    }
//    @PostMapping("/register")
//    public ResponseEntity<?> save(@RequestBody User user) throws UserAlreadyExistsException{
//    	try{
//            userService.saveUser(user);
//            responseEntity = new ResponseEntity(user , HttpStatus.CREATED);
//        }
//        catch(UserAlreadyExistsException p)
//        {
//            throw new UserAlreadyExistsException();
//        }
//        catch(Exception e)
//        {
//            responseEntity=new ResponseEntity<>("Error !!!! Try  after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return responseEntity;
//    }
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) throws InvalidCredentials{
//        Map<String,String>map=null;
//        try {
//            User userobj = userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
//            if (userobj.getPassword().equals(user.getPassword())) {
//                map = securityTokenGenerator.generateToken(user);
//            }
//            responseEntity = new ResponseEntity(map, HttpStatus.OK);
//        } catch (InvalidCredentials ie) {
//            throw new InvalidCredentials();
//        }catch (Exception e)
//        {
//            responseEntity = new ResponseEntity("Try after sometime!!!!",HttpStatus.INTERNAL_SERVER_ERROR);}
//        return responseEntity;
//
//    }
    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public ResponseEntity<?> registerNewUser(@RequestBody User user) throws UserAlreadyExistsException {
        try{
            userService.registerNewUser(user);
            responseEntity = new ResponseEntity(user , HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException p)
        {
            throw new UserAlreadyExistsException();
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity<>("Error !!!! Try  after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
        }

