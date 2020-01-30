package com.twu.menu;

import com.twu.menu.Menu;
import com.twu.collection.Book;
import com.twu.Collection;
import com.twu.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class ListOfBooks implements ListOfItems, Menu {
    private Collection collection = new Collection();
    private Item selectedBook;

    @Override
    public void listAllItems() {
        System.out.println("=============== List of Books ===============");
        for (Item book : collection.getBookList()) {
            System.out.println(book);
        }
        System.out.println("=============================================");
        System.out.println("Do you want to 1) Checkout or 2) Return or 3) Back to Main Menu");
        System.out.print(">>> ");
        this.checkoutOrReturn(this.userInput());
    }

    @Override
    public Item selectItem(String input) {
        Integer inputAsInteger = Integer.parseInt(input);
        Integer convertedID = inputAsInteger - 1;
        this.selectedBook = listOfItemsFromCollection().get(convertedID);
        System.out.println(this.selectedBook);

        return this.selectedBook;
    }

    @Override
    public void checkoutOrReturn(String userChoice) {
        if (userChoice.equals("1")) {
            System.out.println("Please select the book you wish to checkout: ");
            this.selectItem(this.userInput());
            System.out.println("Do you wish to checkout this Book (Y/N) ?");
            String result = this.checkoutItem(this.userInput());
            System.out.println(result);
            this.listAllItems();
        } else if (userChoice.equals("2")) {
            System.out.println("Please select the book you wish to return: ");
            this.selectItem(this.userInput());
            System.out.println("Do you wish to return this Book (Y/N) ?");
            this.returnItem(this.userInput());
            this.listAllItems();
        } else if (userChoice.equals("3")) {
            menu.startMenuSelection();
        } else {
            System.out.println("Invalid, Please fill again");
            this.listAllItems();
        }
    }

    @Override
    public String checkoutItem(String condition) {
        if (!condition.equals("Y") || !this.selectedBook.getIsAvailable()) {
            return "Invalid Checkout";
        }

        this.selectedBook.setAvailable(false);
        return "You have checkout " + this.selectedBook;
    }

    @Override
    public void returnItem(String condition) {
        if (condition.equals("Y")) {
            if (this.selectedBook.getIsAvailable().equals(false)) {
                this.selectedBook.setAvailable(true);
                System.out.println("You have return " + this.selectedBook);
            } else {
                System.out.println("Invalid Return");
            }
        }
    }

    @Override
    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        return s;
    }


    public ArrayList<Book> listOfItemsFromCollection() {
        return this.collection.getBookList();
    }

    @Override
    public void showMenuProperty() {
        this.listAllItems();
    }
}
