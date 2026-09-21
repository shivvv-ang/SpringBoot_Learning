package com.springBoot.MvcSecurity.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

}
