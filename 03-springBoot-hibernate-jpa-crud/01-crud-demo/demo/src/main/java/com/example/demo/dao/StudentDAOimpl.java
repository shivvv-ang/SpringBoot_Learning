package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOimpl implements  StudentDao {

    //define field for entity manager

    private EntityManager em;

    //inject entity manager using constructor injection


    @Autowired
    public StudentDAOimpl(EntityManager em) {
        this.em = em;
    }

    //implement save method

    @Override
    @Transactional
    public void save(Student student){
        em.persist(student);
    }
}
