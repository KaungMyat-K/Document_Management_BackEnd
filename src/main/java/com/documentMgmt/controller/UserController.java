package com.documentMgmt.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.documentMgmt.domain.Response;
import com.documentMgmt.dtorequest.UserRequest;
import com.documentMgmt.services.UserService;
import com.documentMgmt.utils.RequestUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid UserRequest user,HttpServletRequest request) {
        userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        
        return ResponseEntity.created(getUri()).body(RequestUtils.getResponse(request,null,"Account created.Check your email to enable account",HttpStatus.CREATED));
    }
    
    @GetMapping("/verify/account")
    public ResponseEntity<Response> verifyAccount(@RequestParam("key") String tokenKey,HttpServletRequest request) {
        userService.verifyAccountKey(tokenKey);
        return ResponseEntity.created(getUri()).body(RequestUtils.getResponse(request,null,"Account verified.",HttpStatus.OK));
    }



    private URI getUri(){
        return URI.create("");
    }
}
