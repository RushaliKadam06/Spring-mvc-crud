package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/savestudent")
	public ModelAndView testMethod() {
		System.out.println("Project working fine");
		ModelAndView modelAndView = new ModelAndView("createstudent.jsp");
		modelAndView.addObject("student1", new Student());
		return modelAndView;
	}

	@RequestMapping("/studentsave")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		System.out.println("Reaching");
		if (student != null) {
			studentService.saveStudent(student);
		}
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		modelAndView.addObject("save", student.getName() + " saved succesfully");
		return modelAndView;
	}

	@RequestMapping("/viewallstudents")
	public ModelAndView getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		ModelAndView modelAndView = new ModelAndView("viewstudent.jsp");
		modelAndView.addObject("students", students);
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteStudentById(@RequestParam(name = "id") int id) {
		boolean res = false;
		ModelAndView modelAndView = null;
		if (id > 0) {
			res = studentService.deleteStudentById(id);
		}
		if (res == true) {
			modelAndView = new ModelAndView("deleted.jsp");
			modelAndView.addObject("student", "Student deleted successfully");
		}
		return modelAndView;
	}
	
	    @RequestMapping("/update")
		public ModelAndView updateStudent(@RequestParam(name = "id") int id) {
	    	
	    	ModelAndView modelAndView = new ModelAndView("update.jsp");
	    		modelAndView.addObject("student2", new Student());
	    		return modelAndView;
	    	
	    	
	}
	    @RequestMapping("/updatestudent")
	    public ModelAndView updateTest(@ModelAttribute  Student student) {
	        
	    studentService.updateStudent(student.getId(),student);
	    ModelAndView modelAndView = new ModelAndView("home.jsp");
	    modelAndView.addObject("update", "Student"+student.getId()+" Updated successfully");
	    return modelAndView;
	    }
	    
	
}
