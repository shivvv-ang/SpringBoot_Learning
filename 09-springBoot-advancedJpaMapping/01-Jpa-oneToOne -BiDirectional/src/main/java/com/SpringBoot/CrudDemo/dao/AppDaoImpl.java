package com.SpringBoot.CrudDemo.dao;
import com.SpringBoot.CrudDemo.entity.Instructor;
import com.SpringBoot.CrudDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager em;

    @Autowired
    public  AppDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        em.persist(theInstructor);
    }

    @Override
    public Instructor findInstructor(int id){
        return em.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void DeleteInstructor(int id){

        Instructor instructor = em.find(Instructor.class,id);

        em.remove(instructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return em.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id){
        InstructorDetail instructorDetail = em.find(InstructorDetail.class,id);

        em.remove(instructorDetail);
    }
}
