package com.library.repositories;

import com.library.entities.StudentBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBookRepository extends JpaRepository<StudentBook, Long> {
}
