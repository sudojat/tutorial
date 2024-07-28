package com.ubs.project.tutorial.service;

import com.ubs.project.tutorial.model.Student;
import com.ubs.project.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

     @Autowired
    StudentRepository studentRepository;

     public List<Student> getAllStudents(){
         return studentRepository.findAll();
     }


}
