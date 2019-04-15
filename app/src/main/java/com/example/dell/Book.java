package com.example.dell;

public class Book {

    String book_id;
    String book_class;
    String book_name;
    String book_author;
    double book_cost;

    public Book()
    {

    }

    public Book(String book_id,String book_class, String book_name, String book_author, double book_cost) {
        this.book_id=book_id;
        this.book_class = book_class;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_cost = book_cost;
    }

    public String getBook_class() {
        return book_class;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public String getBook_id() {
        return book_id;
    }

    public double getBook_cost() {
        return book_cost;
    }
}
