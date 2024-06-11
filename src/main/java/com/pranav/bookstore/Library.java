package com.pranav.bookstore;

import com.pranav.bookstore.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Library extends MongoRepository<Book,String> {

}
