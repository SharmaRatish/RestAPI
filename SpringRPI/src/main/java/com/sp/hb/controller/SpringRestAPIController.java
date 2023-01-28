package com.sp.hb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.hb.model.ServerResponse;
import com.sp.hb.model.Student;
import com.sp.hb.repo.StudentRepo;
import com.sp.hb.service.StudentServiceImpl;

@RestController
public class SpringRestAPIController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private StudentServiceImpl serviceImpl;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/getstudentlist")
	public List<Student> getStudentsList()
	{
		return serviceImpl.getStudents(studentRepo);
	}
	@GetMapping("/getstudent/{sid}")
	public Student getStudent(@PathVariable String sid) {
		
		return serviceImpl.getStudents(studentRepo, Integer.parseInt(sid));
		
	}
	@PostMapping("/addstudent")
	public ServerResponse addStudent(@RequestBody Student student)
	{
		return serviceImpl.addStudent(studentRepo, student);
	}
	
	
	
	//20-01-2023
	
	
	@GetMapping("/getstudentbycity/{city}")
	public List<Student> getStudentByCity(@PathVariable String city)
	{
		return serviceImpl.getStudentsByCity(studentRepo, city);
	}
	
	
	@DeleteMapping("/deletestudent/{id}")
	public ServerResponse deleteStudent(@PathVariable String id)
	{
		return serviceImpl.deleteStudent(studentRepo, Integer.parseInt(id));
	}
	
	@GetMapping("/byname/{name}")
	public ServerResponse byName(@PathVariable String name)
	{
		return serviceImpl.byName(studentRepo,name);
	}
	
	
	
	@PutMapping("/updatestudent/{id}")
	public ServerResponse updateStudent(@RequestBody Student student)
	{
		return serviceImpl.updateStudent(studentRepo, student);
	}
	
	
}
