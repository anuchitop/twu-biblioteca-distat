package com.twu.biblioteca.books;

import java.util.Date;

public class Book {

    private int id;
    private String title;
    private String author;
    private Date publicationYear;
    private Boolean availability;

    public Book(int id, String title, String author, Date publicationYear, Boolean avaiability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.availability = avaiability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return String.format(this.id+": "+this.title+" by "+this.author);
    }
}
