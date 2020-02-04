package com.twu.collection;

import java.util.Date;

public class Movies extends Item {
    public Movies(int id, String title, String author, Date publicationYear, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;
    }
}
