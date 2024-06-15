package com.pranav.bookstore.index;

import com.pranav.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void createIndex() {
        IndexOperations indexOps = mongoTemplate.indexOps(Book.class);

        // Create an index on the 'genres' field
        indexOps.ensureIndex(new Index().on("genres", Sort.Direction.ASC));

        // Create a compound index on 'author' and 'pubDate' fields
        indexOps.ensureIndex(new Index().on("author", Sort.Direction.ASC));

        // Create a unique index on the 'name' field
        indexOps.ensureIndex(new Index().on("name", Sort.Direction.ASC));

        // Create an index on the 'price' field
        indexOps.ensureIndex(new Index().on("price", Sort.Direction.ASC));

        // Create an index on the 'discount' field
        indexOps.ensureIndex(new Index().on("discount",Sort.Direction.DESC));

        // Create a text index on 'name' and 'desc' fields for text search
        TextIndexDefinition textIndex = new TextIndexDefinition.TextIndexDefinitionBuilder()
                .onField("name")
                .onField("desc")
                .build();
        indexOps.ensureIndex(textIndex);
    }
}
