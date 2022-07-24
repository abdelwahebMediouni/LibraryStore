package com.library.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.controllers.BookController;
import com.library.servicesImpl.BookServiceImpl;
import com.library.servicesImpl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookServiceImpl bookService;
    @Test
    void getAllAvailableBooksTst() throws Exception {
        mockMvc.perform(get("/api/v1/books"))
                .andExpect(status().isOk());

    }

}