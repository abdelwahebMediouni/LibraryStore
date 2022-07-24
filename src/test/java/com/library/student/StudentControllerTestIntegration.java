package com.library.student;

import com.library.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class StudentControllerTestIntegration {


    @Autowired
    private TestRestTemplate restTemplate;

    // Don't use restTemplate because it will try to connect to the app that may not be up, and that will break our test
    @Test
    @Disabled
    public void testGetStudents() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/students", Student[].class);
        Student[] listStudents = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(statusCode.value()).isEqualTo(200);
        assertThat(listStudents.length).isEqualTo(Collections.EMPTY_LIST.size());
    }


}