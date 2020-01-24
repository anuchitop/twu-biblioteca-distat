package com.twu.biblioteca.menu;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.BookCollection;

import java.util.ArrayList;

public class ListOfBooks implements Menu {
    BookCollection bookCollection = new BookCollection();

    @Override
    public void showProperty() {
        ArrayList<Book> listOfBook = bookCollection.fetchBook();
        for (Book book:listOfBook) {
            System.out.println(book);
        }
    }
}
