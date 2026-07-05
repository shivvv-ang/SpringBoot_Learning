package com.SpringBoot.SpringCore.common;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("CricketCoach");
    }

    // define our init method
    @PostConstruct
    public void init(){
        System.out.println("CricketCoach init");
    }

    // define our destroy method

    @PreDestroy
    public void destroy(){
        System.out.println("CricketCoach destroy");
    }


    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes !!";
    }
}
