package com.library.repositories;

import com.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT b From Book b" +
            " LEFT  JOIN StudentBook st on st.id.book_id = b.id" +
            " WHERE st.id.book_id is null " +
            "or  current_date()  > st.finishedReadingOn ")
    List<Book>  getAvaibleBooks();
}

