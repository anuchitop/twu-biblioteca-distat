package com.twu.collection;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    @Test
    public void testOnBookAttribute() {
        Book book = new Book(1, "Unlocking Android", "W. Frank Ableson", new Date(2009, Calendar.JANUARY, 01), true);
        assertEquals("Unlocking Android",book.getTitle());
        assertEquals("W. Frank Ableson",book.getAuthor());
    }

    @Test
    public void testOnMoviesAttribute() {
        Movies movies = new Movies(1, "Friday 13", "Distat Permpoonwiwat", new Date(2009, Calendar.APRIL, 01), true);
        assertEquals("Friday 13", movies.getTitle());
        assertEquals("Distat Permpoonwiwat", movies.getAuthor());
    }
 }