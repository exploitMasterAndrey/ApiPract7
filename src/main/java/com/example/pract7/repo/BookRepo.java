package com.example.pract7.repo;

import com.example.pract7.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findBooksByAuthor_FIO(String authorFIO);
}
