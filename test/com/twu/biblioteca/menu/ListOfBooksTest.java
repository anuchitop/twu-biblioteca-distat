package com.twu.biblioteca.menu;

import com.twu.biblioteca.collection.Book;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOfBooksTest {
    ListOfBooks listOfBooks = new ListOfBooks();

    @Test
    public void selectBookFromTheListShouldReturnProperOne() {
        Book selectedBook = listOfBooks.selectBook("1");

        assertEquals("Unlocking Android", selectedBook.getTitle());
        assertEquals(true, selectedBook.getIsAvailable());
    }

    @Test
    public void checkoutBookShouldChangeTheAvailableState() {
        Book selectedBook = listOfBooks.selectBook("1");

        listOfBooks.checkoutBook("Y");

        assertEquals(false, selectedBook.getIsAvailable());
    }

    // TODO: What if a book is checkout twice?
    // TODO: What if we return book out of nowhere?

    @Test
    public void returnBookShouldChangeTheAvailableState() {
        Book selectedBook = listOfBooks.selectBook("1");

        listOfBooks.checkoutBook("Y");
        listOfBooks.returnBook("Y");

        assertEquals(true, selectedBook.getIsAvailable());
    }
}
