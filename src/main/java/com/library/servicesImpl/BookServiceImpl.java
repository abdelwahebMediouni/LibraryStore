package com.library.servicesImpl;

import com.library.entities.Book;
import com.library.repositories.BookRepository;
import com.library.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getListOfAvailableBooks() {

        return bookRepository.getAvaibleBooks();

    }
}
