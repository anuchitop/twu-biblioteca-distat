package com.twu;

import com.twu.collection.Book;
import com.twu.collection.Movies;

import java.util.ArrayList;
import java.util.Date;

public class Collection {
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Movies> moviesList = new ArrayList<>();

    public ArrayList<Book> getBookList() {
        return bookList;
    }
    public ArrayList<Movies> getMoviesList() { return moviesList; }

    public Collection() {
        this.fetchBook();
        this.fetchMovies();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }
    public void addMovies(Movies movies) {
        this.moviesList.add(movies);
    }

    public Integer getNumberOfBooks() {
        Integer size = this.bookList.size();
        return size;
    }
    public Integer getNumberOfMovies() {
        Integer size = this.moviesList.size();
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

    public ArrayList<Movies> fetchMovies() {
        Movies film1 = new Movies(1, "Friday 13th", "Distat P.", new Date(2020, 02, 14), true);
        Movies film2 = new Movies(2, "How to train your cat", "Distat P. Jr.", new Date(1992, 01, 1), true);
        Movies film3 = new Movies(2, "Drunkirk", "Distat Jr. and Da Gang", new Date(2001, 10, 27), true);
        this.addMovies(film1);
        this.addMovies(film2);
        this.addMovies(film3);
        return moviesList;
    }
}
