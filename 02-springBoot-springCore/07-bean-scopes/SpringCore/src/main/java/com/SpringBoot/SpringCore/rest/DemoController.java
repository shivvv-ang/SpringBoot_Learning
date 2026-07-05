package com.SpringBoot.SpringCore.rest;

import com.SpringBoot.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define private field for dependency injection

    final private Coach myCoach;
    final private Coach anotherCoach;
    @Autowired

    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach
            ) {
        System.out.println("In Constructor" +  getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")

    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing bean : myCoach and anotherCoach" + (myCoach.equals(anotherCoach));
    }
}
