package com.library.student;

import com.library.enums.Gender;
import com.library.entities.Student;
import com.library.repositories.StudentRepository;
import com.library.servicesImpl.StudentServiceImpl;
import com.library.exception.BadRequestException;
import com.library.exception.StudentNotFoundException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.List.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;


    @Test
    void getAllStudentTest() {

        List<Student> listOfStudents = of(
                new Student("ahmed", "ahmed@gmail.com", Gender.MALE),
                new Student("ali", "ali@gmail.com", Gender.MALE),
                new Student("maryem", "maryem@gmail.com", Gender.MALE)
        );
        //given
        given(studentRepository.findAll()).willReturn(listOfStudents);
        //when
        List<Student> list = studentService.getAllStudents();
        //then
        assertThat(list).isEqualTo(listOfStudents);
    }

    @Test
    void getAllStudentWithVerify() {

        //when
        List<Student> list = studentService.getAllStudents();
        //then
        verify(studentRepository).findAll();
    }


    @Test
    @Disabled
    void addStudentTest() {

        //given
        Student student = new Student("abdou", "mediouni.abdelwaheb@gmail.com", Gender.MALE);
        //when
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        //then
        //assertNotNull(studentService.addStudent(student));
    }


    @Test
    void canAddStudentTest() {

        //given
        Student student = new Student("abdou", "mediouni.abdelwaheb@gmail.com", Gender.MALE);
        //when
        studentService.addStudent(student);
        //then
        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {

        //given
        Student student = new Student("abdou", "mediouni.abdelwaheb@gmail.com", Gender.MALE);
        given(studentRepository.selectExistsEmail(student.getEmail())).willReturn(true);
        //when
        //then
        assertThatThrownBy(() -> studentService.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");

        verify(studentRepository, never()).save(any());

    }


    @Test
    void deleteStudentTest() {
        // given
        long id = 10;
        given(studentRepository.existsById(id))
                .willReturn(true);
        // when
        studentService.deleteStudent(id);

        // then
        verify(studentRepository).deleteById(id);
    }

    @Test
    void willThrowsWhenStudentNotFound() {
        // given
        long studentId = 10;
        // when

        // then
        assertThatThrownBy(() -> studentService.deleteStudent(studentId))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining("Student with id " + studentId + " does not exists");
        verify(studentRepository, never()).deleteById(studentId);
    }
}
