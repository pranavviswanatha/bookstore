package com.pranav.bookstore.controller;

import com.pranav.bookstore.service.SearchRepo;
import com.pranav.bookstore.repository.Library;
import com.pranav.bookstore.models.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping (value = "/home")
public class Controller {
    @Autowired
    Library library;
    @Autowired
    private final SearchRepo searchRepo;

    @GetMapping(value = "/getBooks")
    public List<Book> searchMatching(@RequestParam(required = false) String searchText,
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
