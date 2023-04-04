package com.project.UserAuthenticationService.controller;


import com.project.UserAuthenticationService.domain.JwtRequest;
import com.project.UserAuthenticationService.domain.JwtResponse;
import com.project.UserAuthenticationService.exception.InvalidCredentials;
import com.project.UserAuthenticationService.service.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
public class JwtController {

    @Autowired
    private JwtServiceImpl jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception, InvalidCredentials {
        return jwtService.createJwtToken(jwtRequest);
    }
}
