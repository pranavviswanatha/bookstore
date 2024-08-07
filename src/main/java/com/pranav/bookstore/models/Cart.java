package com.pranav.bookstore.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.TreeMap;

@Document(collection = "cart")
public class Cart {
    @Id
    private String id;

    @Indexed
    private String username;
    private TreeMap<String, Integer> cart; //list of id's for books

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TreeMap<String, Integer> getCart() {
        return cart;
    }

    public void setCart(TreeMap<String, Integer> cart) {
        this.cart = cart;
    }

}
