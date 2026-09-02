package com.SpringBoot.ThymeleafDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showform")
    public String showForm(){
        return "helloworld-form";
    }

    @GetMapping("/processform")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String doSomething(HttpServletRequest request, Model model){

        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "YO! "+theName;

        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String doAFlip(@RequestParam("studentName") String theName, Model model){

        theName = theName.toUpperCase();

        String result = "HEY HEY HEY! "+theName;

        model.addAttribute("message", result);

        return "helloworld";
    }

}
