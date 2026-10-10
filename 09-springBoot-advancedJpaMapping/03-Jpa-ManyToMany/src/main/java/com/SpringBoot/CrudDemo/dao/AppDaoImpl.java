package com.SpringBoot.CrudDemo.dao;
import com.SpringBoot.CrudDemo.entity.Course;
import com.SpringBoot.CrudDemo.entity.Instructor;
import com.SpringBoot.CrudDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        List<Course> courses = instructor.getCourses();

        for (Course course : courses) {
            course.setInstructor(null);
        }

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

        instructorDetail.getInstructor().setInstructorDetail(null);

        em.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorById(int id) {

        TypedQuery<Course> query = em.createQuery("from Course where instructor.id=:data", Course.class);

        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public Instructor FindInstructorByIdJoinFetch(int id) {

        TypedQuery<Instructor> query = em.createQuery("select i from Instructor i " +  "JOIN FETCH i.courses " + "JOIN FETCH i.instructorDetail " + "where i.id=:data", Instructor.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        em.merge(theInstructor);
    }

    @Override
    @Transactional
    public void update(Course theCourse) {
        em.merge(theCourse);
    }

    @Override
    public Course findCourseById(int id) {
        return em.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course  course = em.find(Course.class,id);

        em.remove(course);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        em.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsById(int id) {

        TypedQuery<Course> query = em.createQuery(
                "Select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id = :data", Course.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }
}
