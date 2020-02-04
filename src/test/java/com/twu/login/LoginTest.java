package com.twu.login;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LoginTest {
    private Login login;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    
    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        login = new Login(bufferedReader, printStream);
    }

    @Test
    public void shouldPrintInvalidUsernameFormatWhenInputWrongUsernameFormat() throws IOException {
        // Arrange
        when(bufferedReader.readLine()).thenReturn("11-11111");

        // Action
        login.verifyLibraryIDInput();

        // Assert
        verify(printStream).println("Invalid Username Format");
    }

    @Test
    public void shouldReturnInvalidMessageWhenLoggedInWithNonExistingUser() throws IOException {
        // message returned should contain some Invalid message
        // Arrange
        when(bufferedReader.readLine()).thenReturn("444-4444");

        // Action
        login.verifyLibraryIDInput();

        // Assert
        verify(printStream).println("User not existed");
    }

    @Test
    public void shouldReturnInvalidMessageWhenPasswordDoesNotMatch() throws IOException {
        // message returned should contain some Invalid message
        // Arrange
        Account account1 = new Account("John Cena", "111-1111", "password");
        login.setCurrentAccount(account1);

        when(bufferedReader.readLine()).thenReturn("pass");

        // Action
        login.verifyPasswordInput();

        // Assert
        verify(printStream).println("Invalid Password");
    }

    @Test
    public void shouldReturnTrueIfPasswordMatches() throws IOException {
        // Arrange
        Account account1 = new Account("John Cena", "111-1111", "password");
        login.setCurrentAccount(account1);
        when(bufferedReader.readLine()).thenReturn("password");

        // Assert/Action
        assertThat(login.verifyPasswordInput(), is(true));
    }

    @Test
    public void shouldMatchRightCredentialWhenLoggedInAsThatSpecificPerson() throws IOException {
        // Arrange
        when(bufferedReader.readLine()).thenReturn("111-1111");

        // Action
        login.verifyLibraryIDInput();

        // Arrange
        when(bufferedReader.readLine()).thenReturn("password");

        // Action
        login.verifyPasswordInput();

        // Assert
        assertThat(login.getCurrentAccount().getName(), is("John Cena"));
    }
}