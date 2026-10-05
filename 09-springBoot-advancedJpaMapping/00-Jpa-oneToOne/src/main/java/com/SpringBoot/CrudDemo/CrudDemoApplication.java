package com.SpringBoot.CrudDemo;

import com.SpringBoot.CrudDemo.dao.AppDao;
import com.SpringBoot.CrudDemo.entity.Instructor;
import com.SpringBoot.CrudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao theAppDao) {
		return runner -> {

			createInstructor(theAppDao);

		};
	}

	private void createInstructor(AppDao theAppDao) {

//		Instructor theInstructor = new Instructor("pikachu","where","pikachuWhere@gmail.com");
//		InstructorDetail theInstructorDetails = new InstructorDetail("http://www.pikachuWhere.com/youtube","idk sleeping");

		Instructor theInstructor = new Instructor("young","lord","youngLord@gmail.com");

		InstructorDetail theInstructorDetails = new InstructorDetail("http://www.youngLord.com/youtube","football");

		theInstructor.setInstructorDetail(theInstructorDetails);

		System.out.println("Instructor created: " + theInstructor );

		theAppDao.save(theInstructor);
	}
}
