package com.twu.menu;

import com.twu.collection.Book;
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

public class ListOfBooksTest {
    BufferedReader bufferedReader = mock(BufferedReader.class);
    Printer printStream = new MockPrintStream();
    Collection collection = new Collection();
    Account account = new Account("John Cena", "111-1111", "password");
    ListOfBooks listOfBooks = new ListOfBooks(collection, account, printStream, bufferedReader);

    @Test
    public void shouldReturnProperSetOfBooksWhenListAllBooks() {
        List<String> expected = Arrays.asList("1: Unlocking Android by W. Frank Ableson | Availability: true", "2: Locking IOS by C. Frank Unableson | Availability: true", "3: Locking AGAIN IOS by A. Freak Unabledaughter | Availability: true");

        listOfBooks.listAllBooks();

        assertEquals(expected, printStream.getPrinterCapture());
    }

    @Test
    public void shouldReturnTheRightBookWhenSelectBook() throws IOException {
        Book expected = new Book(1, "Unlocking Android", "W. Frank Ableson", new Date(2009, 04, 01), true);
        when(bufferedReader.readLine()).thenReturn(Integer.toString(1));

        Book actual = listOfBooks.selectBook();

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void shouldReturnTrueIfInputY() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Y");
        assertThat(listOfBooks.confirm(), equalTo(true));
    }

    @Test
    public void shouldPrintSelectedBookAndAskForCheckoutWhenCallCheckOutItemMethod() throws IOException {
        List<String> expected = Arrays.asList("Please select the book: ", "1: Unlocking Android by W. Frank Ableson | Availability: true", "Do you wish to checkout this Book (Y/N) ?");

        when(bufferedReader.readLine()).thenReturn(Integer.toString(1));
        listOfBooks.selectBook();
        listOfBooks.checkoutItem();

        assertEquals(expected, printStream.getPrinterCapture());
    }

    @Test
    public void shouldPrintInvalidCheckoutWhenUserSaysNO() throws IOException {
        List<String> expected = Arrays.asList("Please select the book: ", "1: Unlocking Android by W. Frank Ableson | Availability: true", "Do you wish to checkout this Book (Y/N) ?", "Invalid Checkout");

        when(bufferedReader.readLine()).thenReturn(Integer.toString(1));
        listOfBooks.selectBook();

        when(bufferedReader.readLine()).thenReturn("N");

        listOfBooks.checkoutItem();
        listOfBooks.confirmCheckOut();

        assertEquals(expected, printStream.getPrinterCapture());
    }

    @Test
    public void shouldReturnAvailabilityFalseWhenUserCheckoutABook() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        listOfBooks.selectBook();

        when(bufferedReader.readLine()).thenReturn("Y");

        listOfBooks.checkoutItem();
        listOfBooks.confirmCheckOut();

        assertEquals(false, listOfBooks.getSelectedBook().getIsAvailable());
    }

    @Test
    public void shouldPrintSelectedBookAndAskForCheckoutWhenCallReturnItemMethod() throws IOException {
        List<String> expected = Arrays.asList("Please select the book: ", "1: Unlocking Android by W. Frank Ableson | Availability: true", "Do you wish to return this Book (Y/N) ?");
        when(bufferedReader.readLine()).thenReturn("1");
        listOfBooks.selectBook();

        listOfBooks.returnItem();

        assertEquals(expected, printStream.getPrinterCapture());
    }

    @Test
    public void shouldReturnAvailabilityTrueWhenUserReturnABook() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        listOfBooks.selectBook();
//
        when(bufferedReader.readLine()).thenReturn("Y");
//
        listOfBooks.checkoutItem();
        listOfBooks.confirmCheckOut();
//
        assertEquals(false, listOfBooks.getSelectedBook().getIsAvailable());

        when(bufferedReader.readLine()).thenReturn("Y");

        listOfBooks.confirmReturn();

        assertEquals(true, listOfBooks.getSelectedBook().getIsAvailable());
    }
}
