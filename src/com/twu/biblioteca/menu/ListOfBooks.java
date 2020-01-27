package com.twu.biblioteca.menu;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.BookCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class ListOfBooks implements Menu {
    BookCollection bookCollection = new BookCollection();
    Book selectedBook;

    public void listAllBooks() {
        for (Book book:bookCollection.getBookList()) {
            System.out.println(book);
        }
        System.out.println("Do you want to Checkout or Return");
        this.checkoutOrReturn(this.userInput());
    }

    public Book selectBook(String input) {
        Integer inputAsInteger = Integer.parseInt(input);
        Integer convertedID = inputAsInteger-1;
        this.selectedBook = listOfBooksFromCollection().get(convertedID);
        System.out.println(this.selectedBook);

        return this.selectedBook;
    }

    public void checkoutOrReturn(String userChoice) {
        System.out.println("Please select the book you wish to proceed: ");
        this.selectBook(this.userInput());

        if (userChoice.equals("Checkout")) {
            System.out.println("Do you wish to checkout this Book (Y/N) ?");
            this.checkoutBook(this.userInput());
            this.listAllBooks();
        } else if (userChoice.equals("Return")) {
            System.out.println("Do you wish to return this Book (Y/N) ?");
            this.returnBook(this.userInput());
            this.listAllBooks();
        }
    }

    public void checkoutBook(String condition) {
        if (condition.equals("Y")) {
            if (this.selectedBook.getIsAvailable()) {
                this.selectedBook.setAvailable(false);
                System.out.println("You have checkout "+this.selectedBook);
            } else {
                System.out.println("Invalid Checkout");
            }
        } else { ; }
    }

    public void returnBook(String condition) {
        if (condition.equals("Y")) {
            if (this.selectedBook.getIsAvailable().equals(false)) {
                this.selectedBook.setAvailable(true);
                System.out.println("You have return "+this.selectedBook);
            } else {
                System.out.println("Invalid Return");
            }
        } else { ; }
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        return s;
    }

    public ArrayList<Book> listOfBooksFromCollection() {
        return this.bookCollection.getBookList();
    }

    @Override
    public void showMenuProperty() {
        this.listAllBooks();
    }
}
