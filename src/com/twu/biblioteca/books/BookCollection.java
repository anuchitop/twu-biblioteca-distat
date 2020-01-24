package com.twu.biblioteca.books;

import java.util.ArrayList;
import java.util.Date;

public class BookCollection {
    private ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public Integer getNumberOfBooks() {
        Integer size = this.bookList.size();
        return size;
    }

    public ArrayList<Book> fetchBook() {
        Book book = new Book(1, "Unlocking Android", "W. Frank Ableson", new Date(2009, 04, 01), true);
        Book book2 = new Book(2, "Locking IOS", "C. Frank Unableson", new Date(2017, 06, 22), true);
        bookList.add(book);
        bookList.add(book2);
        return bookList;
    }
}
