package com.SpringBoot.ThymeleafDemo.controller;
import com.SpringBoot.ThymeleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> language;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showstudentform")
    public String showForm(Model model) {

        Student student = new Student();

        model.addAttribute("student", student);

        model.addAttribute("countries", countries);

        model.addAttribute("language", language);

        model.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {

        System.out.println("TheStudent" + student.getFirstName()+" "+student.getLastName());

        return "student-confirmation";
    }
}
