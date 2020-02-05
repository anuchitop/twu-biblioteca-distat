package com.twu.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import com.twu.collection.Collection;

public class MenuSelection {
    private Map<Integer, Menu> menuMap = new HashMap<>();
    private BufferedReader bufferedReader;
    private Printer printStream;
    private Collection collection;
    private ListOfBooks listOfBooks;
    private ListOfMovies listOfMovies;

    public MenuSelection() {
        collection = new Collection();
        listOfBooks = new ListOfBooks();
        listOfMovies = new ListOfMovies();
        this.mapMenuWithID();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public MenuSelection(Printer printStream, BufferedReader bufferedReader) {
        collection = new Collection();
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    // TODO: Menu selection is still buggy and need refactor
    public void startMenuSelection() throws IOException {
        listAllMenus();
        selectMenu();
    }

    public void selectMenu() throws IOException {
        System.out.println("Enter Menu Number: ");
        this.getMenuByInput(userInput()).showMenuProperty();
    }

    public Menu getMenuByInput(Integer menuID) {
        System.out.println(menuMap.keySet());
        if (menuMap.containsKey(menuID)) {
            return menuMap.get(menuID);
        }
        return null;
    }

    private void mapMenuWithID() {
        this.menuMap.put(1, listOfBooks);
        this.menuMap.put(2, listOfMovies);
        this.menuMap.put(3, new QuitApplication());
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
