package com.SpringBoot.ThymeleafDemo.controller;
import com.SpringBoot.ThymeleafDemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showstudentform")
    public String showForm(Model model) {

        Student student = new Student();

        model.addAttribute("student", student);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {

        System.out.println("TheStudent" + student.getFirstName()+" "+student.getLastName());

        return "student-confirmation";
    }
}
