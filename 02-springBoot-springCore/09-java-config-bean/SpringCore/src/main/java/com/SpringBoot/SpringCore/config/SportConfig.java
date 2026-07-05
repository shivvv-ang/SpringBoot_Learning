package com.SpringBoot.SpringCore.config;

import com.SpringBoot.SpringCore.common.Coach;
import com.SpringBoot.SpringCore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
