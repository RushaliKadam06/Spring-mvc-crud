package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Student;

@Component
public class StudentDao {

	@Autowired
	  EntityManagerFactory entityManagerFactory;
	
	public Student saveStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	
	public List<Student> getAllStudents(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		 String sql="Select s From Student s";
		 
		  Query query= entityManager.createQuery(sql);
		     
		List<Student> students=   query.getResultList();
		return students;
	}
	
	public boolean deleteStudentById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Student student= entityManager.find(Student.class,id);
		if(student!=null) {
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return true;
		}else {
			return false;
		}
	}
	
	public Student getStudentById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	public Student updateStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(student!=null) {
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
		}else {
			return null;
		}
	}
	
	
	
}
