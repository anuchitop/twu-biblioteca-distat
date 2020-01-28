package com.twu.biblioteca.menu;

import java.util.*;

public class MenuSelection {
    private Map<Integer, Menu> menuMap = new HashMap<>();

    public MenuSelection() {
        this.mapMenuWithID();
    }

    public void startMenuSelection() {
        System.out.println("Please select the following menu by number");
        System.out.println("1: List of Books");
        System.out.println("2: List of Movies");
        System.out.println("3: Quit Application");
        System.out.print("Enter Menu Number: ");
        selectMenu(userInput()).showMenuProperty();
    }

    private Map<Integer, Menu> mapMenuWithID() {
        this.menuMap.put(1, new ListOfBooks());
        this.menuMap.put(2, new ListOfMovies());
        this.menuMap.put(3, new QuitApplication());
        return menuMap;
    }

    public Menu selectMenu(Integer input) {
        return this.getMenu(input);
    }

    private Integer userInput() {
        Scanner menuID = new Scanner(System.in);
        Integer input = menuID.nextInt();
        return input;
    }

    public Menu getMenu(Integer menuID) {
        if (menuMap.keySet().contains(menuID)) {
            return menuMap.get(menuID);
        } else {
            return null;
        }
    }
}
