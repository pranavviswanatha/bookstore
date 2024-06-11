package com.pranav.bookstore.controller;

import com.pranav.bookstore.Library;
import com.pranav.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    Library library;
    @GetMapping(value = "/allBooks")
    public List<Book> getAllBooks () {
        return library.findAll();
    }
}
