package com.pranav.bookstore.controller;

import com.pranav.bookstore.index.SearchRepo;
import com.pranav.bookstore.repository.Library;
import com.pranav.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    Library library;
    @GetMapping(value = "/allBooks")
    public List<Book> getAllBooks () {
        return library.findAll();
    }

    @GetMapping(value = "/booksMatching")
    public List<Book> search(@RequestParam String searchText){
        SearchRepo searchRepo = new SearchRepo();
        return searchRepo.searchBooks(searchText);
    }

    @PostMapping(value = "/addBook")
    public Book addBook (@RequestBody Book book) {
        return library.save(book);
    }

    @PostMapping(value = "/addCollection")
    public List<Book> addCollection (@RequestBody List<Book> collection) {
        return library.saveAll(collection);
    }
}
