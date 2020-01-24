package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.Biblioteca;
import org.junit.Before;
import org.junit.Rule;
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
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        String className = app.selectMenu().getClass().getSimpleName();
        assertEquals("ListOfBooks", className);
    }
}