package com.project.UserService.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.UserService.domain.User;


@FeignClient(name = "user-authentication-service",url = "localhost:9091")
public interface UserProxy {

	
	@PostMapping("/registerNewUser")
    public ResponseEntity<?> registerNewUser(@RequestBody User user);
}
