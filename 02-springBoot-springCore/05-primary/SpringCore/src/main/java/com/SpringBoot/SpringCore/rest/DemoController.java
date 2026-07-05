package com.SpringBoot.SpringCore.rest;

import com.SpringBoot.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define private field for dependency injection

    final private Coach myCoach;

    @Autowired

    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")

    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
