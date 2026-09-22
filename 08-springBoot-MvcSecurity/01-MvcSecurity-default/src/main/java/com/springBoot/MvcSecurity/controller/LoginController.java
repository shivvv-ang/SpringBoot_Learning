package com.springBoot.MvcSecurity.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "loginPage";
    }


    @GetMapping("/accessDenied")
    public String showAccessDeniedPage(){
        return "accessDenied";
    }
}
