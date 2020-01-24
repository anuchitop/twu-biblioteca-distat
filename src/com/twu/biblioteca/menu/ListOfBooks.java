package com.twu.biblioteca.menu;

public class ListOfBooks implements Menu {
    public String ListOfBooks() {
        System.out.println("List of Books");
        return "List of Books";
    }
    @Override
    public void showProperty() {
        System.out.println("List of Books");
    }
}
