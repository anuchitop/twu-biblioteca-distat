package com.twu.biblioteca;

import com.twu.biblioteca.collection.Collection;
import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.menu.MenuSelection;

public class Biblioteca {
    private Collection collection = new Collection();

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public Menu getMenu(Integer inputNum) {
        MenuSelection menuSelection = new MenuSelection();
        return menuSelection.getMenu(inputNum);
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.showWelcomeMessage());
        MenuSelection menu = new MenuSelection();
        menu.startMenuSelection();
    }
}
