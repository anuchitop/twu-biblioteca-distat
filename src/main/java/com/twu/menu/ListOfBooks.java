package com.twu.menu;

import com.twu.collection.Book;
import com.twu.collection.Collection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListOfBooks implements Menu {
    private BufferedReader bufferedReader;
    private Printer printStream;
    private Collection collection;
    private Book selectedBook;

    public Book getSelectedBook() {
        return selectedBook;
    }

    public ListOfBooks() {
        collection = new Collection();
        this.printStream = new PrinterImpl();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public ListOfBooks(Printer printStream, BufferedReader bufferedReader) {
        collection = new Collection();
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void property() throws IOException {
        printStream.println("=============== List of Books ===============");
        listAllBooks();
        printStream.println("=============================================");
        checkoutOrReturn();
    }

    public void listAllBooks() {
        for (Book book : collection.getBookList()) {
            printStream.println(book.toString());
        }
    }

    public Book selectBook() throws IOException {
        printStream.println("Please select the book: ");
        Integer bookID = Integer.parseInt(userInput());
        this.selectedBook = listOfBooksFromCollections().get(bookID - 1);
        return this.selectedBook;
    }

    public void checkoutOrReturn() throws IOException {
        printStream.println("Do you want to 1) Checkout or 2) Return or 3) Back to Main Menu");
        printStream.print(">>> ");
        Integer userChoice = Integer.parseInt(userInput());
        switch (userChoice) {
            case 1:
                selectBook();
                doCheckout();
                break;
            case 2:
                selectBook();
                doReturn();
                break;
            case 3:
                menu.startMenuSelection();
                break;
            default:
                printStream.println("Invalid, Please fill again");
                this.property();
                break;
        }
    }

    // ===================== Checkout ===================== //
    public void doCheckout() throws IOException {
        checkoutItem();
        confirmCheckOut();
        // Back to main property
        property();
    }

    public void checkoutItem() {
        printStream.println(selectedBook.toString());
        printStream.println("Do you wish to checkout this Book (Y/N) ?");
    }

    public void confirmCheckOut() throws IOException {
        Boolean userConfirmation = confirm();
        if (!userConfirmation || !this.selectedBook.getIsAvailable()) {
            printStream.println("Invalid Checkout");
        } else {
            this.selectedBook.setAvailable(false);
            printStream.println("You have checkout " + this.selectedBook);
        }
    }
    // ==================================================== //


    // ===================== Return ===================== //

    public void doReturn() throws IOException {
        returnItem();
        confirmReturn();
        // Back to main property
        property();
    }
    public void returnItem() {
        printStream.println(selectedBook.toString());
        printStream.println("Do you wish to return this Book (Y/N) ?");
    }

    public void confirmReturn() throws IOException {
        Boolean userConfirmation = confirm();
        if (!userConfirmation || this.selectedBook.getIsAvailable()) {
            printStream.println("Invalid Return");
        } else {
            this.selectedBook.setAvailable(true);
            printStream.println("You have return " + this.selectedBook);
        }
    }

    // ==================================================== //


    public String userInput() throws IOException {
        return bufferedReader.readLine();
    }

    public Boolean confirm() throws IOException {
        String userInput = userInput();
        return userInput.equals("Y");
    }


    public ArrayList<Book> listOfBooksFromCollections() {
        return this.collection.getBookList();
    }

    @Override
    public void showMenuProperty() throws IOException {
        this.property();
    }
}
