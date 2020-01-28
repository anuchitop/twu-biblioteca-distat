package com.twu.biblioteca.menu;

import com.twu.biblioteca.collection.Book;
import com.twu.biblioteca.collection.Item;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOfBooksTest {
    ListOfBooks listOfBooks = new ListOfBooks();

    @Test
    public void selectBookFromTheListShouldReturnProperOne() {
        Item selectedBook = listOfBooks.selectItem("1");

        assertEquals("Unlocking Android", selectedBook.getTitle());
        assertEquals(true, selectedBook.getIsAvailable());
    }

    @Test
    public void checkoutBookShouldChangeTheAvailableState() {
        Item selectedBook = listOfBooks.selectItem("1");

        listOfBooks.checkoutItem("Y");

        assertEquals(false, selectedBook.getIsAvailable());
    }

    // TODO: What if a book is checkout twice?
    // TODO: What if we return book out of nowhere?

    @Test
    public void returnBookShouldChangeTheAvailableState() {
        Item selectedBook = listOfBooks.selectItem("1");

        listOfBooks.checkoutItem("Y");
        listOfBooks.returnItem("Y");

        assertEquals(true, selectedBook.getIsAvailable());
    }
}
