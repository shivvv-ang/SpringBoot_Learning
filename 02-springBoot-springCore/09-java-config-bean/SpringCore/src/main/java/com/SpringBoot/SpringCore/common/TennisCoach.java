package com.SpringBoot.SpringCore.common;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach(){
        System.out.println("TennisCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Your Back Hand";
    }
}
