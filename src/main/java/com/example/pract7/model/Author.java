package com.example.pract7.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String FIO;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> books;

    public Author(){}

    public Author(Long id, String FIO, List<Book> books) {
        this.id = id;
        this.FIO = FIO;
        this.books = books;
    }

    public String getFIO() {
        return FIO;
    }

    public List<Book> getBooks() {
        return books;
    }
}
