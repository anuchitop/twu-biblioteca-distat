package com.twu.biblioteca.menu;

public class MenuFactory {
    public Menu getMenu(int menuID) {
        if (menuID == 1) {
            return new ListOfBooks();
        }
        if (menuID == 2) {
            return new Others();
        }
        return null;
    }
}
