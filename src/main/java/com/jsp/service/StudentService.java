package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@Component
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}
	
	public List<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
	
	public boolean deleteStudentById(int id) {
		return studentDao.deleteStudentById(id);
	}
    
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}
	
	public Student updateStudent(int id, Student student) {
	
    	Student student1 = studentDao.getStudentById(id);
    	if(student1!=null) {
    		student1.setEmail(student.getEmail());
    		student1.setName(student.getName());
    		return studentDao.updateStudent(student1);
    	}else {
    		return null;
    	}
    	
	}

}
