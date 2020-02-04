package com.twu.collection;

//import com.twu.menu.Menu;
import com.twu.Collection;
import com.twu.Item;
import com.twu.menu.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class ListOfMovies implements ListOfItems, Menu {
    private Collection collection = new Collection();
    private Item selectedMovies;

    @Override
    public void listAllItems() {
        System.out.println("=============== List of Movies ===============");
        for (Item movies : collection.getMoviesList()) {
            System.out.println(movies);
        }
        System.out.println("=============================================");
        System.out.println("Do you want to 1) Checkout or 2) Return or 3) Back to Main Menu");
        System.out.print(">>> ");
        this.checkoutOrReturn(this.userInput());
    }

    @Override
    public Item selectItem(String input) {
        Integer inputAsInteger = Integer.parseInt(input);
        Integer convertedID = inputAsInteger - 1;
        this.selectedMovies = listOfItemsFromCollection().get(convertedID);
        System.out.println(this.selectedMovies);

        return this.selectedMovies;
    }

    @Override
    public void checkoutOrReturn(String userChoice) {
        if (userChoice.equals("1")) {
            System.out.println("Please select the movies you wish to checkout: ");
            this.selectItem(this.userInput());
            System.out.println("Do you wish to checkout this movies (Y/N) ?");
            String result = this.checkoutItem(this.userInput());
            System.out.println(result);
            this.listAllItems();
        } else if (userChoice.equals("2")) {
            System.out.println("Please select the movies you wish to return: ");
            this.selectItem(this.userInput());
            System.out.println("Do you wish to return this movies (Y/N) ?");
            this.returnItem(this.userInput());
            this.listAllItems();
        } else if (userChoice.equals("3")) {
            menu.startMenuSelection();
        } else {
            System.out.println("Invalid, Please fill again");
            this.listAllItems();
        }
    }

    @Override
    public String checkoutItem(String condition) {
        if (!condition.equals("Y") || !this.selectedMovies.getIsAvailable()) {
            return "Invalid Checkout";
        }

        this.selectedMovies.setAvailable(false);
        return "You have checkout " + this.selectedMovies;
    }

    @Override
    public void returnItem(String condition) {
        if (condition.equals("Y")) {
            if (this.selectedMovies.getIsAvailable().equals(false)) {
                this.selectedMovies.setAvailable(true);
                System.out.println("You have return " + this.selectedMovies);
            } else {
                System.out.println("Invalid Return");
            }
        }
    }

    @Override
    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        return s;
    }


    public ArrayList<Movies> listOfItemsFromCollection() {
        return this.collection.getMoviesList();
    }

    @Override
    public void showMenuProperty() {
        this.listAllItems();
    }
}


