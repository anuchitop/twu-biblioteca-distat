package com.twu.collection;

import com.twu.login.Account;

import java.util.Date;

public abstract class Item {
    protected int id;
    protected String title;
    protected String author;
    protected Date publicationYear;
    protected Boolean isAvailable;

    protected String owner;

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

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%d: %s by %s | Availability: %s", this.id, this.title, this.author, isAvailable ? "true" : "false | Owned by: "+this.owner);
    }
}
