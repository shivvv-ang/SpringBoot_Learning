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

			//createStudent(studentDao);

			//CreateMultipleStudent(studentDao);

			readStudent(studentDao);
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

	private void CreateMultipleStudent(StudentDao studentDao) {
		//create student object

		Student student1 = new Student("atharva","khedulkar","atharva@gmail.com");
		Student student2 = new Student("sumit","kissan","kissan@gmail.com");
		Student student3 = new Student("arin","b","arinb@gmail.com");

		//save the student object
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);

		//alter table student_tracker.student auto_increment=3000 way to change auto increment data
	}

	private void readStudent(StudentDao studentDao) {

		Student temp = new Student("champa","chameli","chameli@gmail.com");

		studentDao.save(temp);

		int id =  temp.getId();

		Student student = studentDao.findById(id);

		System.out.println(student);
	}
}
