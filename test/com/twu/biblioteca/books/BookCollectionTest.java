package com.twu.biblioteca.books;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookCollectionTest {
    BookCollection bookCollection = new BookCollection();

    @Test
    public void testOnBookAttribute() {
        Book book = new Book(1, "Unlocking Android", "W. Frank Ableson", new Date(2009, 04, 01), true);
        assertEquals("Unlocking Android",book.getTitle());
        assertEquals("W. Frank Ableson",book.getAuthor());
    }

    @Test
    public void testAddingBookToCollection() {
        Book book = new Book(1, "Unlocking Android", "W. Frank Ableson", new Date(2009, 04, 01), true);
        bookCollection.addBook(book);
        assertEquals(1, bookCollection.getNumberOfBooks());
        Book book2 = new Book(2, "Lock IOS", "C. Frank Unableson", new Date(2017, 06, 22), true);
        bookCollection.addBook(book2);
        assertEquals(2, bookCollection.getNumberOfBooks());
    }
}
