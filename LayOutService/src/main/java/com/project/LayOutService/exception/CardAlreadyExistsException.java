package com.project.LayOutService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "Card already exists")
public class CardAlreadyExistsException extends Throwable{

}
