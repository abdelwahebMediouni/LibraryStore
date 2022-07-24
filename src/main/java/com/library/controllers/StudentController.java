package com.library.controllers;

import com.library.servicesImpl.StudentServiceImpl;
import com.library.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }


    public void bookLoan(){

    }
}