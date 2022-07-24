package com.library.controllers;

import com.library.entities.Book;
import com.library.servicesImpl.BookServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@AllArgsConstructor
public class BookController {


    private final BookServiceImpl bookService;
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_ADHERENT')")
    public List<Book> getAllAvailableBooks() {
        return bookService.getListOfAvailableBooks();
    }

}
