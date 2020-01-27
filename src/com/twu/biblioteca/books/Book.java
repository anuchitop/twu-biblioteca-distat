package com.twu.biblioteca.books;

import java.util.Date;

public class Book {

    private int id;
    private String title;
    private String author;
    private Date publicationYear;
    private Boolean isAvailable;

    public Book(int id, String title, String author, Date publicationYear, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;
    }

    public int getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublicationYear() { return publicationYear; }

    public Boolean getIsAvailable() { return isAvailable; }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format(this.id+": "+this.title+" by "+this.author + " | Availability: "+this.isAvailable);
    }
}
