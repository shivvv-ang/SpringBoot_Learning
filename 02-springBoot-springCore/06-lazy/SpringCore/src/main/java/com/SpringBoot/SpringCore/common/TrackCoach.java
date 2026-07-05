package com.SpringBoot.SpringCore.common;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println("TrackCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Run a Hard 5k";
    }
}
