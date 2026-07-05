package com.springbootExploration.explore.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    //Expose "/" that returns "hello World"

    @GetMapping("/")

    public String sayHello(){
        return "Hello World!";
    }

    //expose  a new endpoint for "workout"

    @GetMapping("/workout")

    public String getDailyWorkout(){
        return "Run a Hard 5k";
    }

    //Exposing a new endpoint for fortune

    @GetMapping("/fortune")

    public String getDailyFortune(){
        return "Every Damn Day is your lucky day bitch!";
    }
}
