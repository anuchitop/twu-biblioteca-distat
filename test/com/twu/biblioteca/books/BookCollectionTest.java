package com.twu.biblioteca.books;

import org.junit.Test;
import java.util.Date;

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
    public void testFetchingBookFromTheDB() {
        assertEquals(3, bookCollection.getNumberOfBooks());
    }
}
