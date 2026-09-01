package com.SpringBoot.ThymeleafDemo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String SayHello(Model theModel) {

        theModel.addAttribute("TheDate", java.time.LocalDateTime.now());

        return "helloworld";
    }
}
