package com.falcon.application.controller;

import com.falcon.application.ResponseBuilder;
import com.falcon.application.ResponseMessage;
import com.falcon.domain.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class HelloWorld {
    @Autowired
    private UserAuthService userAuthService;

    @GetMapping(value = "/hello", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseMessage<String>> hello(){
        return new ResponseBuilder<String>().buildForGetSuccess("Hello World!");
    }

    @GetMapping(value = "/auth", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseMessage<String>> getUser(){
        return new ResponseBuilder<String>().buildForGetSuccess("success!");
    }
}
