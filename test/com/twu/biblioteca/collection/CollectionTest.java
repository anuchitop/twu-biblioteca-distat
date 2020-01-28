package com.twu.biblioteca.collection;

import org.junit.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTest {
    Collection collection = new Collection();

    @Test
    public void testFetchingBookFromDB() {
        assertEquals(3, collection.getNumberOfBooks());
    }

    @Test
    public void testFetchingMoviesFromDB() { assertEquals(3, collection.getNumberOfMovies()); }
}
