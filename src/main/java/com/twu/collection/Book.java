package com.twu.collection;

import com.twu.Item;

import java.util.Date;

public class Book extends Item {
    public Book(int id, String title, String author, Date publicationYear, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;
    }
}
