package com.rajat.sms.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class HelloController {

    @Operation(summary="Hello")
    @GetMapping("/hello") 
    public String hello(){
        return "hello world";
    }
    @Operation(summary="About Me")

@GetMapping("/about")
public String about(){
    return "i am Rajat Software Engineer AND im learning regular";
}
    @Operation(summary="What I am Learning",description="Click on TRY It Out And Then Execute , See Response Body FOR Answer")

@GetMapping("/course")
public String course(){
    return "Java,Spring boot,Flutter";
}



} 
