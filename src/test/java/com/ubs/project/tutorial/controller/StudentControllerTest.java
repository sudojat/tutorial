package com.ubs.project.tutorial.controller;

import com.ubs.project.tutorial.model.Student;
import com.ubs.project.tutorial.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.ubs.project.tutorial.model.Class;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    public void testCreateStudent() throws Exception {

        Class mockClass = new Class();
        mockClass.setId(101);
        mockClass.setName("Math");

        // Create a Student object and set the mocked Class as the foreign key
        Student student = new Student();
        student.setId(1);
        student.setFirstName("Alice");
        student.setLastName("Johnson");
        student.setDateOfBirth(LocalDate.of(2005,6,15));
        student.setStudentClass(mockClass);  // Set the mocked Class object


       // Student student = new Student(1, "Alice", "Johnson", LocalDate.of(2005,6,15),1);


        when(studentService.addStudent(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("/student/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1, \" firstName\" : \"Alice\", \"lastName\" : \"Johnson\", \"dateOfBirth\" : \"dateOfBirth\" : \"2005-06-15\",\"studentClass\" : 1}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Alice"))
                .andExpect(jsonPath("$.studentClass.id").value(101));  // Ensure the foreign key is mocked correctly


    }

}
