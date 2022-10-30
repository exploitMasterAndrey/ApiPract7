package com.example.pract7.model;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String genre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Author getAuthor() {
        return author;
    }

    public Book(){}

    public Book(String name, String genre, Author author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
    }
}
