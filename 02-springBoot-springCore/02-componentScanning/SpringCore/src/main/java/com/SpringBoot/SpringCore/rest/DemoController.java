package com.SpringBoot.SpringCore.rest;

import com.SpringBoot.SpringCore.common.Coach;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define private field for dependency injection

    private final Coach myCoach;

    //define a constructor for dependency injection

    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")

    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
