package com.library.student;

import com.library.entities.Student;
import com.library.enums.Gender;
import com.library.repositories.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailExists() {
        //given
        String email = "jamila@gmail.com";
        Student student = new Student(
                "Jamila",
                email,
                Gender.FEMALE
        );
        underTest.save(student);
        //when
        boolean exists = underTest.selectExistsEmail(email);

        //then
        assertThat(exists).isTrue();
    }

    @Test
    void itShouldCheckIfStudentEmailNotExists() {
        //given
        String email = "jamila@gmail.com";

        //when
        boolean exists = underTest.selectExistsEmail(email);

        //then
        assertThat(exists).isFalse();
    }
}