package com.twu.biblioteca.menu;

import java.util.HashMap;

public class MenuFactory {
//    public static Menu invalidMenu = new Menu
    private int menuID;
    private boolean isListOfBooks;
    private boolean isOthers;
    private Map<int, Menu> mapping = {
            1 -> ListOfBooks.,
    }

    public MenuFactory(int menuID) {
        this.menuID = menuID;
        this.isListOfBooks = this.menuID == 1;
        this.isOthers = this.menuID == 2;
    }

    public Menu getMenu() {
        if (this.isListOfBooks) {
            return new ListOfBooks();
        }

        if (this.isOthers) {
            return new Others();
        }

        else {
            return null;
        }
    }
}


// 1 -> ListOfBook
// 2 -> dddcc
