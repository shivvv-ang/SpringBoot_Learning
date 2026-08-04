package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

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

    @Override
    public Student findById(Integer id){
        return em.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){

        TypedQuery<Student> theQuery = em.createQuery("From Student Order by lastName",Student.class);

        return theQuery.getResultList();
    }

    @Override
     public  List<Student> findByLasName(String lasName){

        TypedQuery<Student> theQuery = em.createQuery("From Student Where lastName=:theData",Student.class);

        theQuery.setParameter("theData",lasName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id){

        Student student = em.find(Student.class,id);

        em.remove(student);
    }


    @Override
    @Transactional
    public int deleteAll(){

        int rowsAffected = em.createQuery("delete from Student").executeUpdate();

        return rowsAffected;
    }

}
