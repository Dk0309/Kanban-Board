package com.project.UserAuthenticationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Email and Password is Not Valid")
public class InvalidCredentials extends Throwable {
}
