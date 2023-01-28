package com.sp.hb.service;

import java.util.List;

import com.sp.hb.model.ServerResponse;
import com.sp.hb.model.Student;
import com.sp.hb.repo.StudentRepo;

public interface StudentService {

	public List<Student> getStudents(StudentRepo sRepo);
	public Student getStudents(StudentRepo sRepo,int id);
	public ServerResponse addStudent(StudentRepo sRepo,Student student);
	
	//20/jan/2023
	
	public List<Student> getStudentsByCity(StudentRepo sRepo,String city);
	
	public ServerResponse deleteStudent(StudentRepo sRepo,int id);
	
	public ServerResponse updateStudent(StudentRepo sRepo,Student stu);
	
	public ServerResponse byName(StudentRepo sRepo,String name);
	
}
