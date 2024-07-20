package com.pranav.bookstore.controller;

import com.pranav.bookstore.service.SearchRepo;
import com.pranav.bookstore.repository.Library;
import com.pranav.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/home")
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
    public List<Book> search(@RequestParam(required = false) String searchText,
                             @RequestParam(required = false) List<String> genres){
        return searchRepo.searchBooks(searchText, genres);
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
