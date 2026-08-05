package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("atharva","khedukar"));
        students.add(new Student("sumit","kissan"));
        students.add(new Student("Arin","b"));
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId)
    {
        return students.get(studentId);
    }

}
