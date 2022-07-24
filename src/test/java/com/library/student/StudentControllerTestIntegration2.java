package com.library.student;

import com.library.entities.Student;
import com.library.enums.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-it.properties"
)
@AutoConfigureMockMvc
@SqlGroup({
@Sql(scripts = "classpath:db/populateDB.sql"),
@Sql(scripts = "classpath:db/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
})
public class StudentControllerTestIntegration2 {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getAllStudents() throws Exception {
    /*    MvcResult result =   mockMvc.perform(get("/api/v1/students"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);*/
        mockMvc.perform(get("/api/v1/students"))
                .andExpect(jsonPath("$.*", hasSize(3)));

    }

    @Test
    void addStudent() throws Exception {

        //given
        String name = "abdel";
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

        mockMvc.perform(delete("/api/v1/students/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //then
    }
}

