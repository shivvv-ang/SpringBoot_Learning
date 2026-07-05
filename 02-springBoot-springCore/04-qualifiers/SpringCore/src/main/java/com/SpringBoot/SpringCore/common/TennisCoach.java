package com.SpringBoot.SpringCore.common;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice Your Back Hand";
    }
}
