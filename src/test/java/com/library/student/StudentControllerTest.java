package com.library.student;

import com.library.controllers.StudentController;
import com.library.entities.Student;
import com.library.enums.Gender;
import com.library.servicesImpl.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentServiceImpl studentService;

    @Test
    void getAllStudents() throws Exception {
        mockMvc.perform(get("/api/v1/students"))
                .andExpect(status().isOk());

    }

    @Test
    void addStudent() throws Exception {

        //given
        String name ="abdel";
                Student student = new Student(
                name,
                String.format("%s@amigoscode.edu",
                        StringUtils.trimAllWhitespace(name.trim().toLowerCase())),
                Gender.FEMALE
        );
        //when
     mockMvc.perform(post("/api/v1/students")
     .contentType(MediaType.APPLICATION_JSON)
     .content(objectMapper.writeValueAsString(student)))
             .andExpect(status().isOk());


    }

    @Test
    void deleteStudent() throws Exception {
        //given
        //when

        mockMvc.perform(delete("/api/v1/students/{id}", "11")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //then
    }
}