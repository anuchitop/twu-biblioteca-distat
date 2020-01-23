package com.twu.biblioteca.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
    private Biblioteca app = new Biblioteca();

    @Test
    public void testWelcomeMessage() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", app.showWelcomeMessage());
    }

    @Test
    public void testMainMenu() {

    }
}