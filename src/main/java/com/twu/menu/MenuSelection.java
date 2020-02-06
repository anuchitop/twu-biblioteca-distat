package com.twu.menu;

import java.io.IOException;
import java.util.*;
import com.twu.collection.Collection;
import com.twu.login.Account;

public class MenuSelection {
    private ListOfBooks listOfBooks;
    private ListOfMovies listOfMovies;
    private Account currentAccount;

    public MenuSelection(Collection collection, Account account) {
        currentAccount = account;
        listOfBooks = new ListOfBooks(collection, currentAccount);
        listOfMovies = new ListOfMovies(collection, currentAccount);
    }

    public void startMenuSelection() throws IOException {
        listAllMenus();
        selectMenu();
    }

    public void selectMenu() throws IOException {
        System.out.println("Enter Menu Number: ");
        this.getMenuByInput(userInput()).showMenuProperty();
    }

    public Menu getMenuByInput(Integer menuID) {
        if (menuID.equals(1)) {
            return listOfBooks;
        } else if (menuID.equals(2)) {
            return listOfMovies;
        } else {
            return new QuitApplication();
        }
    }

    private Integer userInput() {
        Scanner menuID = new Scanner(System.in);
        return menuID.nextInt();
    }

    private void listAllMenus() {
        System.out.println("Please select the following menu by number");
        System.out.println("1: List of Books");
        System.out.println("2: List of Movies");
        System.out.println("3: Quit Application");
    }
}