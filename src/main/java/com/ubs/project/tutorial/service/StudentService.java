package com.ubs.project.tutorial.service;

import com.ubs.project.tutorial.model.Student;
import com.ubs.project.tutorial.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

     @Autowired
    StudentRepository studentRepository;

     public Student addStudent(Student student){
         Student savedStudent = studentRepository.save(student);
         return savedStudent;
     }

     public void deleteStudent(Long studentId){
         if(studentRepository.existsById(studentId)){
             studentRepository.deleteById(studentId);
         }
         else{
             throw new EntityNotFoundException("Student not found with id: "+ studentId);
         }
     }

     public List<Student> getAllStudents(){
         return studentRepository.findAll();
     }



}
