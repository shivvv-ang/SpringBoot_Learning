package com.SpringBoot.CrudDemo.dao;

import com.SpringBoot.CrudDemo.entity.Course;
import com.SpringBoot.CrudDemo.entity.Instructor;
import com.SpringBoot.CrudDemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructor(int id);

    void DeleteInstructor(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorById(int id);

    Instructor FindInstructorByIdJoinFetch(int id);

    void update(Instructor  theInstructor);

    void update(Course  theCourse);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course theCourse);

    Course findCourseAndReviewsById(int id);

    //void deleteCourseAndReviewsById(int id);
}
