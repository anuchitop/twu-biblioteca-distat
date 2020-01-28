package com.twu.biblioteca.collection;

import org.junit.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTest {
    Collection collection = new Collection();

    @Test
    public void testOnBookAttribute() {
        Book book = new Book(1, "Unlocking Android", "W. Frank Ableson", new Date(2009, 04, 01), true);
        assertEquals("Unlocking Android",book.getTitle());
        assertEquals("W. Frank Ableson",book.getAuthor());
    }

    @Test
    public void testFetchingBookFromTheDB() {
        assertEquals(3, collection.getNumberOfBooks());
    }
}
