package com.pranav.bookstore.index;

import com.pranav.bookstore.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IndexInitializer implements CommandLineRunner {

    @Autowired
    private IndexService indexService;

    @Override
    public void run(String... args) throws Exception {
        indexService.createIndex();
    }
}
