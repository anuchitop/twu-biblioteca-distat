package com.twu.biblioteca.collection;

import java.util.ArrayList;
import java.util.Date;

public class Collection {
    private ArrayList<Book> bookList = new ArrayList<>();

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public Collection() {
        this.fetchBook();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public Integer getNumberOfBooks() {
        Integer size = this.bookList.size();
        return size;
    }

    // This method will be refactored when we have to fetch data directly from DB
    // It is currently using mock data.
    public ArrayList<Book> fetchBook() {
        Book book = new Book(1, "Unlocking Android", "W. Frank Ableson", new Date(2009, 04, 01), true);
        Book book2 = new Book(2, "Locking IOS", "C. Frank Unableson", new Date(2017, 06, 22), true);
        Book book3 = new Book(3, "Locking AGAIN IOS", "A. Freak Unabledaughter", new Date(2017, 06, 22), true);
        this.addBook(book);
        this.addBook(book2);
        this.addBook(book3);
        return bookList;
    }
}
