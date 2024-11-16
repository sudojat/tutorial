package com.ubs.project.tutorial.controller;

import com.ubs.project.tutorial.model.Student;
import com.ubs.project.tutorial.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(Student student){
        Student savedstudent = studentService.addStudent(student);
        return new ResponseEntity<Student>(savedstudent,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

   @GetMapping("/delete/{student_id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId){
        try{
            studentService.deleteStudent(studentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
   }


}
