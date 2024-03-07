package com.spring.orm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public int insert(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        Integer i = (Integer) session.save(student);
        return i;
    }
    
    //get single object
    @Transactional
    public Student getById(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, studentId);
    }
    
    //get all students
    @Transactional
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        
        String sql = "FROM Student";
        return session.createQuery(sql, Student.class).getResultList();

    }
    
    //update student
    @Transactional
    public int updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
        return student.getId(); // Assuming getId() returns the student's ID
    }
    
    
    
    //delete student
    @Transactional
    public Student deleteStudent(int studentId) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        if (student != null) {
            session.delete(student);
        }
		return student;
    }
    
}
