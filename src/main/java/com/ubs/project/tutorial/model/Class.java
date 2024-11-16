package com.ubs.project.tutorial.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Classs")
public class Class {

    @Id
    int id;

    String name;

    String classTeacher;

    @OneToOne
    @JoinColumn(name = " monitor")
    private  Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}
