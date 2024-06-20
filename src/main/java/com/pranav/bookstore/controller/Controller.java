package com.pranav.bookstore.controller;

import com.pranav.bookstore.index.SearchRepo;
import com.pranav.bookstore.repository.Library;
import com.pranav.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    Library library;

    private final SearchRepo searchRepo;

    @Autowired
    public Controller(SearchRepo searchRepo) {
        this.searchRepo = searchRepo;
    }

    @GetMapping(value = "/allBooks")
    public List<Book> getAllBooks () {
        return library.findAll();
    }

    @GetMapping(value = "/booksMatching")
    public List<Book> search(@RequestParam String searchText){
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
