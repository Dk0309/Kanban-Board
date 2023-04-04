package com.project.LayOutService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Board Not Found")
public class PillarNotFoundException extends Throwable{

}
