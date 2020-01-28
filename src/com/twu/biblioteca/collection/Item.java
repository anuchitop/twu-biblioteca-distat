package com.twu.biblioteca.collection;

import java.util.Date;

public abstract class Item {
    protected int id;
    protected String title;
    protected String author;
    protected Date publicationYear;
    protected Boolean isAvailable;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format(this.id+": "+this.title+" by "+this.author + " | Availability: "+this.isAvailable);
    }
}
