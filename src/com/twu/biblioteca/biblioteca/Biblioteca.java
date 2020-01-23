package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.books.BookCollection;
import com.twu.biblioteca.menu.MenuFactory;

public class Biblioteca {
    private BookCollection bookCollection = new BookCollection();

    public Biblioteca() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void showMenu(int input) {
        MenuFactory menuFactory = new MenuFactory();
        menuFactory.getMenu(input);
    }
}
