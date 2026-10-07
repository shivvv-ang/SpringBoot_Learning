package com.SpringBoot.CrudDemo;

import com.SpringBoot.CrudDemo.dao.AppDao;
import com.SpringBoot.CrudDemo.entity.Course;
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

			//createInstructor(theAppDao);
			//findInstructor(theAppDao);
			//deleteInstructor(theAppDao);
			//findInstructorDetail(theAppDao);
			//deleteInstructorDetails(theAppDao);
			createInstructorWithCourses(theAppDao);
		};
	}

	private void createInstructorWithCourses(AppDao theAppDao) {

		Instructor theInstructor = new Instructor("pikachu","where","pikachuWhere@gmail.com");
     	InstructorDetail theInstructorDetails = new InstructorDetail("http://www.pikachuWhere.com/youtube","idk sleeping");
		theInstructor.setInstructorDetail(theInstructorDetails);

		Course c1 = new Course("React Js ultimate something");
		Course c2 = new  Course("Node Js ultimate something");

		theInstructor.add(c1);
		theInstructor.add(c2);

		System.out.println("saving instructor" + theInstructor);
		System.out.println("The Courses"+theInstructor.getCourses());
		theAppDao.save(theInstructor);

	}

	private void deleteInstructorDetails(AppDao theAppDao) {

		int theId = 3;

		System.out.println("Delete Instructor Details" + theId);

		theAppDao.deleteInstructorDetailById(theId);

		System.out.println("Done Deleting the Instructor Details of" + theId);

	}

	private void findInstructorDetail(AppDao theAppDao) {

		int theId = 2;
		InstructorDetail tempInstructorDetail = theAppDao.findInstructorDetailById(theId);

		System.out.println(" Instructor Details "+tempInstructorDetail);

		System.out.println(" associated Instructor " + tempInstructorDetail.getInstructor());

		System.out.println("Done");

	}

	private void deleteInstructor(AppDao theAppDao) {
		int id = 1;
		System.out.println("Deleting Instructor with id " + id);
		theAppDao.DeleteInstructor(id);
		System.out.println("Deleted Instructor with id " + id);
	}

	private void findInstructor(AppDao theAppDao) {

		int id = 2;
		Instructor instructor = theAppDao.findInstructor(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("the associated instructor is " + instructor.getInstructorDetail());
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
