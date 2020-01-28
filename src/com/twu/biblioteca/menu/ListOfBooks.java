package com.twu.biblioteca.menu;

import com.twu.biblioteca.collection.Book;
import com.twu.biblioteca.collection.Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ListOfBooks implements Menu {
    private Collection collection = new Collection();
    private Book selectedBook;

    public void listAllBooks() {
        System.out.println("=============== List of Books ===============");
        for (Book book : collection.getBookList()) {
            System.out.println(book);
        }
        System.out.println("=============================================");
        System.out.println("Do you want to 1) Checkout or 2) Return or 3) Back to Main Menu");
        System.out.print(">>> ");
        this.checkoutOrReturn(this.userInput());
    }

    public Book selectBook(String input) {
        Integer inputAsInteger = Integer.parseInt(input);
        Integer convertedID = inputAsInteger - 1;
        this.selectedBook = listOfBooksFromCollection().get(convertedID);
        System.out.println(this.selectedBook);

        return this.selectedBook;
    }

    public void checkoutOrReturn(String userChoice) {
        if (userChoice.equals("1")) {
            System.out.println("Please select the book you wish to checkout: ");
            this.selectBook(this.userInput());
            System.out.println("Do you wish to checkout this Book (Y/N) ?");
            String result = this.checkoutBook(this.userInput());
            System.out.println(result);
            this.listAllBooks();
        } else if (userChoice.equals("2")) {
            System.out.println("Please select the book you wish to return: ");
            this.selectBook(this.userInput());
            System.out.println("Do you wish to return this Book (Y/N) ?");
            this.returnBook(this.userInput());
            this.listAllBooks();
        } else if (userChoice.equals("3")) {
            MenuSelection menu = new MenuSelection();
            menu.startMenuSelection();
        } else {
            System.out.println("Invalid, Please fill again");
            this.listAllBooks();
        }
    }

    public String checkoutBook(String condition) {
        if (!condition.equals("Y") || !this.selectedBook.getIsAvailable()) {
            return "Invalid Checkout";
        }

        this.selectedBook.setAvailable(false);
        return "You have checkout " + this.selectedBook;
    }

    public void returnBook(String condition) {
        if (condition.equals("Y")) {
            if (this.selectedBook.getIsAvailable().equals(false)) {
                this.selectedBook.setAvailable(true);
                System.out.println("You have return " + this.selectedBook);
            } else {
                System.out.println("Invalid Return");
            }
        }
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        return s;
    }

    public ArrayList<Book> listOfBooksFromCollection() {
        return this.collection.getBookList();
    }

    @Override
    public void showMenuProperty() {
        this.listAllBooks();
    }
}
