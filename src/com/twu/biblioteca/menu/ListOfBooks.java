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
        System.out.println("Please select the book you wish to proceed: ");
        this.selectBook(this.userInput());
        System.out.println("Do you wish to checkout this Book (Y/N) ?");
        this.checkout(this.userInput());
        this.listAllBooks();
    }

    public Book selectBook(String input) {
        Integer inputAsInteger = Integer.parseInt(input);
        Integer convertedID = inputAsInteger-1;
        this.selectedBook = listOfBooksFromCollection().get(convertedID);
        System.out.println(this.selectedBook);

        return this.selectedBook;
    }

    public void checkout(String condition) {
        if (condition.equals("Y")) {
            if (this.selectedBook.getIsAvailable()) {
                this.selectedBook.setAvailable(false);
                System.out.println("You have checkout "+this.selectedBook);
            } else {
                System.out.println("This book is not available");
            }
        } if (condition.equals("N")) {
            ;
        }
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
