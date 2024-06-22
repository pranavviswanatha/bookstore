package com.pranav.bookstore.index;

import com.pranav.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SearchRepo {

    @Autowired
    private final MongoTemplate mongoTemplate;

    @Autowired
    public SearchRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Book> searchBooks(String searchText, List<String> genres) {
        Query query = new Query();
        if (searchText != null && searchText.isEmpty()) {
            TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matchingPhrase(searchText);
            query.addCriteria(textCriteria);
        }
        if (genres != null && !genres.isEmpty()){
            query.addCriteria(Criteria.where("genres").in(genres));
        }
        return mongoTemplate.find(query, Book.class);
    }
}
