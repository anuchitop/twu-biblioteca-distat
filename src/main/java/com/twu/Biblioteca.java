package com.twu;

import com.twu.menu.Menu;
import com.twu.menu.MenuSelection;

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
