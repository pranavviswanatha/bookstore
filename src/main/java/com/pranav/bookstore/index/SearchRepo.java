package com.pranav.bookstore.index;

import com.pranav.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Book> searchBooks(String searchText) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matchingPhrase(searchText);

        Query query = new Query(textCriteria);
        return mongoTemplate.find(query, Book.class);
    }
}
