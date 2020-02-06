package com.twu.menu;

import com.twu.collection.Movies;
import com.twu.collection.Collection;
import com.twu.login.Account;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListOfMoviesTest {
    BufferedReader bufferedReader = mock(BufferedReader.class);
    Printer printStream = new MockPrintStream();
    Collection collection = new Collection();
    Account account = new Account("John Cena", "111-1111", "password");
    ListOfMovies listOfMovies = new ListOfMovies(collection, account, printStream, bufferedReader);


    @Test
    public void shouldReturnProperSetOfMoviesWhenListAllMovies() {
        List<String> expected = Arrays.asList("1: Friday 13th by Distat P. | Availability: true", "2: How to train your cat by Distat P. Jr. | Availability: true", "2: Drunkirk by Distat Jr. and Da Gang | Availability: true");

        listOfMovies.listAllMovies();

        assertEquals(expected, printStream.getPrinterCapture());
    }

    @Test
    public void shouldReturnTheRightMoviesWhenSelectMovies() throws IOException {
        Movies expected = new Movies(1, "Friday 13th", "Distat P.", new Date(2020, 02, 14), true);
        when(bufferedReader.readLine()).thenReturn(Integer.toString(1));

        Movies actual = listOfMovies.selectMovies();

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void shouldReturnTrueIfInputY() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Y");
        assertThat(listOfMovies.confirm(), equalTo(true));
    }

    @Test
    public void shouldPrintSelectedMoviesAndAskForCheckoutWhenCallCheckOutItemMethod() throws IOException {
        List<String> expected = Arrays.asList("Please select the Movies: ", "1: Friday 13th by Distat P. | Availability: true", "Do you wish to checkout this Movies (Y/N) ?");

        when(bufferedReader.readLine()).thenReturn(Integer.toString(1));
        listOfMovies.selectMovies();
        listOfMovies.checkoutItem();

        assertEquals(expected, printStream.getPrinterCapture());
    }

    @Test
    public void shouldPrintInvalidCheckoutWhenUserSaysNO() throws IOException {
        List<String> expected = Arrays.asList("Please select the Movies: ", "1: Friday 13th by Distat P. | Availability: true", "Do you wish to checkout this Movies (Y/N) ?", "Invalid Checkout");

        when(bufferedReader.readLine()).thenReturn(Integer.toString(1));
        listOfMovies.selectMovies();

        when(bufferedReader.readLine()).thenReturn("N");

        listOfMovies.checkoutItem();
        listOfMovies.confirmCheckOut();

        assertEquals(expected, printStream.getPrinterCapture());
    }

    @Test
    public void shouldReturnAvailabilityFalseWhenUserCheckoutAMovies() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        listOfMovies.selectMovies();

        when(bufferedReader.readLine()).thenReturn("Y");

        listOfMovies.checkoutItem();
        listOfMovies.confirmCheckOut();

        assertEquals(false, listOfMovies.getSelectedMovies().getIsAvailable());
    }

    @Test
    public void shouldPrintSelectedMoviesAndAskForCheckoutWhenCallReturnItemMethod() throws IOException {
        List<String> expected = Arrays.asList("Please select the Movies: ", "1: Friday 13th by Distat P. | Availability: true", "Do you wish to return this Movies (Y/N) ?");
        when(bufferedReader.readLine()).thenReturn("1");
        listOfMovies.selectMovies();

        listOfMovies.returnItem();

        assertEquals(expected, printStream.getPrinterCapture());
    }

    @Test
    public void shouldReturnAvailabilityTrueWhenUserReturnAMovies() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        listOfMovies.selectMovies();

        when(bufferedReader.readLine()).thenReturn("Y");

        listOfMovies.checkoutItem();
        listOfMovies.confirmCheckOut();

        assertEquals(false, listOfMovies.getSelectedMovies().getIsAvailable());

        when(bufferedReader.readLine()).thenReturn("Y");

        listOfMovies.confirmReturn();

        assertEquals(true, listOfMovies.getSelectedMovies().getIsAvailable());
    }
}
