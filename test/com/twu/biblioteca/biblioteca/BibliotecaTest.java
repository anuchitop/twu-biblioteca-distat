package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.menu.ListOfBooks;
import com.twu.biblioteca.menu.Menu;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
    private Biblioteca app = new Biblioteca();

    @Test
    public void welcomeMessageShouldAppearWhenRunningTheApp() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", app.showWelcomeMessage());
    }

    @Test
    public void choosingMenuIDShouldReturnTheRightMenu() {
        // Valid input
        assertEquals("ListOfBooks", app.getMenu(1).getClass().getSimpleName());
        assertEquals("Others", app.getMenu(2).getClass().getSimpleName());
    }

    @Test
    public void choosingInvalidMenuReturnNull() {
        // Input as zero
        Menu className = app.getMenu(0);
        assertEquals(null, className);
    }
}