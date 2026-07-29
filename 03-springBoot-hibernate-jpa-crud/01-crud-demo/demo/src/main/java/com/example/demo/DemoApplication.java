package com.example.demo;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner->{
			createStudent(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {
		//create student object

		Student student = new Student("john","doe","johndoe@gmail.com");

		//save the student object
		studentDao.save(student);

		//display the id of the saved student
		System.out.println("Created student with id "+student.getId());
	}
}
