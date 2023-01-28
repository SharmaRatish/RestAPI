package com.sp.hb.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sp.hb.model.ServerResponse;
import com.sp.hb.model.Student;
import com.sp.hb.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	List<Student> slist;
	@Override
	public List<Student> getStudents(StudentRepo sRepo) {
		// TODO Auto-generated method stub
		slist = new LinkedList<Student>();
		Iterable<Student> itr = sRepo.findAll();
		Iterator<Student> itrIterator = itr.iterator();
		while (itrIterator.hasNext()) {
			Student s = itrIterator.next();
			slist.add(s);
		}
		return slist;
	}

	@Override
	public Student getStudents(StudentRepo sRepo, int id) {
		// TODO Auto-generated method stub
		Optional<Student> optional = sRepo.findById(id);
		Student s = optional.get();
		return s;
	}

	@Override
	public ServerResponse addStudent(StudentRepo sRepo, Student student) {
		// TODO Auto-generated method stub
		sRepo.save(student);
		ServerResponse sr = new ServerResponse();
		sr.setStatus(200);
		sr.setMessage("Record Added Successfully");
		return sr;
	}

	// 20-01-2023

	@Override
	public List<Student> getStudentsByCity(StudentRepo sRepo, String city) {

		slist = getStudents(sRepo);
		List<Student> mylist = new LinkedList<Student>();
		for (Student s : slist) {
			if (s.getAddress().equalsIgnoreCase(city)) {
				mylist.add(s);
			}

		}
		return mylist;

	}

	@Override
	public ServerResponse deleteStudent(StudentRepo sRepo, int id) {

		Student s = getStudents(sRepo, id);

		ServerResponse sr = new ServerResponse();
		if (s != null) {
			sRepo.delete(s);
			sr.setMessage("Record Deleted");
			sr.setStatus(200);

		} else {
			sr.setMessage("Record Not Exist ");
			sr.setStatus(200);
		}

		return sr;
	}

	@Override
	public ServerResponse updateStudent(StudentRepo sRepo, Student stu) {

		ServerResponse sr = new ServerResponse();
		if (stu.getSid() == 0) {
			sr.setMessage("Provide Student Id");
			sr.setStatus(200);

		} else {
			Student s = getStudents(sRepo, stu.getSid());
			if (s != null) {
				s.setAddress(stu.getAddress());
				s.setAge(stu.getAge());
				sRepo.save(s);
				sr.setMessage("Record Updated");
				sr.setStatus(200);
			} else {
				sr.setMessage("Record not found");
				sr.setStatus(200);
			}

		}

		return sr;
	}

	@Override
	public ServerResponse byName(StudentRepo sRepo, String name) {
				// TODO Auto-generated method stub
			
			List<Student> record=sRepo.getStudentByName(name);
			
			ServerResponse sr=new ServerResponse();
			if(record.size()!=0)
			{
				sr.setList(record);
				sr.setMessage("Record found");
				sr.setStatus(200);
				
			}
			else {
				sr.setMessage("Record Not Exist ");
				sr.setStatus(200);
			}
			
			return sr;
		}
	
}