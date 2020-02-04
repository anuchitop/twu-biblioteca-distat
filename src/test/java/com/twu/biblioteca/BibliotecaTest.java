package com.twu.biblioteca;

import com.twu.Biblioteca;
import com.twu.login.Account;
import com.twu.menu.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaTest {
    private Biblioteca app;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        app = new Biblioteca(bufferedReader, printStream);
    }

    @Test
    public void shouldShowRightMessageWhenLoggedInAsSpecificUser() {
        Account mockAccount = new Account("John Cena", "111-1111", "password");
        app.setAccount(mockAccount);
        app.initBibliotecaWithLoggedInAccount();
        assertThat(app.getAccount().getName(), equalTo("John Cena"));
        verify(printStream).println("Welcome: John Cena");
    }

    @Test
    public void choosingMenuIDShouldReturnTheRightMenu() {
        // Valid input
        assertEquals("ListOfBooks", app.getMenu(1).getClass().getSimpleName());
        assertEquals("ListOfMovies", app.getMenu(2).getClass().getSimpleName());
    }

    @Test
    public void choosingInvalidMenuReturnNull() {
        // Input as zero
        Menu className = app.getMenu(0);
        assertEquals(null, className);
    }
}