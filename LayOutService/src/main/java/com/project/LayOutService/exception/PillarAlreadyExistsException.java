package com.project.LayOutService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "Board already exists")
public class PillarAlreadyExistsException extends Throwable {

}
