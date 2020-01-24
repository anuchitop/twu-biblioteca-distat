package com.twu.biblioteca.menu;

public class Invalid implements Menu {
    public String invalidInput() {
        return null;
    }

    @Override
    public void showProperty() {
        System.out.println("Invalid Input");
    }
}
