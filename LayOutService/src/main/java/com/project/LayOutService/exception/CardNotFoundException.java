package com.project.LayOutService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Card Not Found")
public class CardNotFoundException extends Throwable {

}
