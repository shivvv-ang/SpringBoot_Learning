package com.springbootExploration.explore.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    //Expose "/" that returns "hello World"

    @GetMapping("/")

    public String sayHello(){
        return "Hello World!";
    }
}
