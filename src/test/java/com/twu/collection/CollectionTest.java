package com.twu.collection;

import com.twu.Collection;
import org.junit.Test;

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
