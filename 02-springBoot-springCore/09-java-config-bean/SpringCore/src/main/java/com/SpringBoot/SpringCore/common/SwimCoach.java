package com.SpringBoot.SpringCore.common;

public class SwimCoach implements Coach{


    public SwimCoach(){
        System.out.println("SwimCoach()");
    }

    @Override

    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
