package com.guru.student.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guru.student.entity.Student;
import com.guru.student.repository.AddressRepository;
import com.guru.student.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@GetMapping(value = "/")
	public String home() {
		return "hello";
	}
	
	@GetMapping("/student")
    public List<Student> index(){
        return studentRepo.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> show(@PathVariable String id){
        int StudentId = Integer.parseInt(id);
        return studentRepo.findById(StudentId);
    }

    @PostMapping("/addStudent")
    public Student create(@RequestBody Map<String, String> body){
        int rollno = Integer.parseInt(body.get("rollno"));
        String name = body.get("name");
        return studentRepo.save(new Student(rollno, name));
    }

    @PutMapping("/updateStudent/{id}")
    public Student update(@PathVariable String id, @RequestBody Map<String, String> body){
        int studentId = Integer.parseInt(id);
        // getting Student
        Optional<Student> student = studentRepo.findById(studentId);
        int rollno = Integer.parseInt(body.get("rollno"));
        String name = body.get("name");
        
        Student obj = student.get();
        obj.setRollno(rollno);
        obj.setName(name);
        Student s = studentRepo.save(obj);
        return s;
    }

    @DeleteMapping("deleteStudent/{id}")
    public boolean delete(@PathVariable String id){
        int studentId = Integer.parseInt(id);
        studentRepo.deleteById(studentId);
        return true;
    }
}
