package com.library.services;

import com.library.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(Long studentId);
}
