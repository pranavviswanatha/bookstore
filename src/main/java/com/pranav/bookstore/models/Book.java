package com.pranav.bookstore.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "database")
public class Book {
    private String name;
    private String author;
    private long pubDate;
    private double price;
    private double discount;

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pubDate=" + pubDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
