package com.SpringBoot.CrudDemo.dao;

import com.SpringBoot.CrudDemo.entity.Instructor;
import com.SpringBoot.CrudDemo.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructor(int id);

    void DeleteInstructor(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
