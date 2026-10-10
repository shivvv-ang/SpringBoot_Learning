package com.SpringBoot.CrudDemo;

import com.SpringBoot.CrudDemo.dao.AppDao;
import com.SpringBoot.CrudDemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao theAppDao) {
		return runner -> {

			//createCourseAndStudents(theAppDao);
			//findCourseAndStudent(theAppDao);
			//findStudentAndCourses(theAppDao);
			//addMoreCoursesForStudent(theAppDao);
			//deleteCourse(theAppDao);
			
			deleteStudent(theAppDao);
		};
	}

	private void deleteStudent(AppDao theAppDao) {

		int id = 1;

		System.out.println("Deleting student with id " + id);

		theAppDao.deleteStudentById(id);

		System.out.println("done");

	}

	private void addMoreCoursesForStudent(AppDao theAppDao) {

		int id = 2;

		Student student = theAppDao.findStudentAndCoursesByStudentId(id);

		Course c1 = new Course("Rubik's Cube - How to Speed Cube");
		Course c2 = new Course("Atari 2600 - Game Development");

		student.addCourse(c1);
		student.addCourse(c2);

		System.out.println("saving Student" + student);
		System.out.println("Associated Courses" + student.getCourses());

		theAppDao.update(student);

		System.out.println("done");

	}

	private void findStudentAndCourses(AppDao theAppDao) {

		int id = 2;

		Student student = theAppDao.findStudentAndCoursesByStudentId(id);

		System.out.println("Student: " + student);
		System.out.println("Courses:" + student.getCourses());

		System.out.println("done");

	}

	private void findCourseAndStudent(AppDao theAppDao) {

		int id = 10;

		Course course = theAppDao.findStudentsAndCoursesById(id);

		System.out.println("Course : " + course);
		System.out.println("Student : " + course.getStudents());

		System.out.println("done");
	}

	private void createCourseAndStudents(AppDao theAppDao) {

		Course  course = new Course("Spring Boot");

		Student st1 = new Student("john","Doe","johnDoe@gmail.com");
		Student st2 = new Student("azu","maril","azumaril@gmail.com");

		course.addStudent(st1);
		course.addStudent(st2);

		System.out.println("Saving the course" + course);
		System.out.println("Associated students" + course.getStudents());

		theAppDao.save(course);

		System.out.println("done");

	}

	private void deleteCourseAndReviews(AppDao theAppDao) {

		int id = 10;

		System.out.println("Delete Course and Reviews by ID" + id);

		theAppDao.deleteCourseById(id);

		System.out.println("done");
	}

	private void retrieveCourseAndReviews(AppDao theAppDao) {

		int id = 10;

		Course 	tempCourse = theAppDao.findCourseAndReviewsById(id);

		System.out.println(tempCourse);

		System.out.println(tempCourse.getReviews());

		System.out.println("done");

	}

	private void createCourseAndReviews(AppDao theAppDao) {

		Course theCourse = new Course("Spring Boot - Crud Demo");

		theCourse.addReview(new Review("Great course .. loved it"));
		theCourse.addReview(new Review("cool course .. job well done"));
		theCourse.addReview(new Review("what a dumb course , you are an idiot"));

		System.out.println("Saving the Course");
		System.out.println(theCourse);
		System.out.println(theCourse.getReviews());

		theAppDao.save(theCourse);

		System.out.println("done");

	}

	private void deleteCourse(AppDao theAppDao) {

		int theId = 10;

		System.out.println("Deleting Course with id: " + theId);

		theAppDao.deleteCourseById(theId);

		System.out.println("Done");

	}

	private void updateCourse(AppDao theAppDao) {
		int theId = 10;

		Course course = theAppDao.findCourseById(theId);

		System.out.println("Updating course id" + theId);

		course.setTitle("Spring Boot Shenanigans");

		theAppDao.update(course);

		System.out.println("done");
	}

	private void updateInstructor(AppDao theAppDao) {

		int theId = 1;

		Instructor theInstructor = theAppDao.findInstructor(theId);

		System.out.println("Updating Instructor with ID: " + theId);

		theInstructor.setLastName("chimapnzee");

		theAppDao.update(theInstructor);

	}

	private void findInstructorWithCoursesJoinFetch(AppDao theAppDao) {

		int theId = 1;

		System.out.println("Finding instructor with id " + theId);

		Instructor instructor = theAppDao.FindInstructorByIdJoinFetch(theId);

		System.out.println("Found instructor with id " + instructor);

		System.out.println("the associated courses : " +  instructor.getCourses());

		System.out.println("Done");
	}

	private void findCoursesForInstructor(AppDao theAppDao) {

		int theId = 1;

		System.out.println("Finding instructor with id " + theId);

		Instructor tempInstructor = theAppDao.findInstructor(theId);

		System.out.println("the instructor is " + tempInstructor);


		System.out.println("Finding courses for the Instructor id " + theId);

		List<Course> courses = theAppDao.findCoursesByInstructorById(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the courses are " + tempInstructor.getCourses());

		System.out.println("Done");

	}

	private void findInstructorWithCourses(AppDao theAppDao) {

		int theId = 1;

		System.out.println("Finding instructor with id " + theId);

		Instructor tempInstructor = theAppDao.findInstructor(theId);

		System.out.println("the instructor is " + tempInstructor);

		System.out.println("associated courses are" + tempInstructor.getCourses());

		System.out.println("done");

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
