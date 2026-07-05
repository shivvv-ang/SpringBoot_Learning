package com.SpringBoot.SpringCore.common;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    public BaseBallCoach(){
        System.out.println("BaseBallCoach");
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }
}
