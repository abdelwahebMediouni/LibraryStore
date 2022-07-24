package com.library.services;

import com.library.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getListOfAvailableBooks();
}
