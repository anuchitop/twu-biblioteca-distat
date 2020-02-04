package com.twu.menu;

import java.util.*;

public class MenuSelection {
    private Map<Integer, Menu> menuMap = new HashMap<>();

    public MenuSelection() {
        this.mapMenuWithID();
    }

    // TODO: Menu selection is still buggy and need refactor
    public void startMenuSelection() {
        listAllMenus();
        selectMenu();
    }

    private Map<Integer, Menu> mapMenuWithID() {
        this.menuMap.put(1, new ListOfBooks());
        this.menuMap.put(2, new ListOfMovies());
        this.menuMap.put(3, new QuitApplication());
        return menuMap;
    }

    public void selectMenu() {
        System.out.println("Enter Menu Number: ");
        this.getMenuByInput(userInput()).showMenuProperty();
    }

    public Menu getMenuByInput(Integer menuID) {
        if (menuMap.keySet().contains(menuID)) {
            return menuMap.get(menuID);
        } else {
            return null;
        }
    }

    private Integer userInput() {
        Scanner menuID = new Scanner(System.in);
        Integer input = menuID.nextInt();
        return input;
    }

    private void listAllMenus() {
        System.out.println("Please select the following menu by number");
        System.out.println("1: List of Books");
        System.out.println("2: List of Movies");
        System.out.println("3: Quit Application");
    }
}
