package com.example.pract7.controller;

import com.example.pract7.model.Author;
import com.example.pract7.model.Book;
import com.example.pract7.repo.AuthorRepo;
import com.example.pract7.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    AuthorRepo authorRepo;

    @QueryMapping
    List<Book> books(){ return bookRepo.findAll(); }

    @QueryMapping
    List<Book> findBooksByAuthor(@Argument String authorFIO) { return bookRepo.findBooksByAuthor_FIO(authorFIO); }

    @MutationMapping
    Book addBook(@Argument BookInput bookInput){
        Optional<Author> author = authorRepo.findById(bookInput.authorID);
        Book book = new Book(bookInput.name, bookInput.genre, author.get());
        return bookRepo.save(book);
    }

    record BookInput(String name, String genre, Long authorID){}
}
