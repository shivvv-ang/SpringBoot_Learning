package com.SpringBoot.SpringCore.common;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println("TrackCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Run a Hard 5k";
    }
}
