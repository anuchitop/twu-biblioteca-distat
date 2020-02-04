package com.twu.biblioteca;

import com.twu.Biblioteca;
import com.twu.login.Account;
import com.twu.login.Login;
import com.twu.menu.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class BibliotecaTest {
    ArrayList<Account> accountList;
    Account account1 = new Account("John Cena", "111-1111", "password");
    Account account2 = new Account("Peter Parker", "222-2222", "password2");
    Account account3 = new Account("Elon Mustnot", "333-3333", "password3");
    private Biblioteca app;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    @Before
    public void setUp() throws IOException {
        accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
//        Login login = new Login(accountList, bufferedReader, printStream);
//        app = new Biblioteca(login);

        app.initBiblioteca();
    }

    @Test
    public void welcomeMessageShouldAppearWhenRunningTheApp() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", app.showWelcomeMessage());
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