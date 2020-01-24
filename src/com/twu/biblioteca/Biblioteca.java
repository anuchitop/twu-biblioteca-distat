package com.twu.biblioteca;

import com.twu.biblioteca.books.BookCollection;
import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.menu.MenuFactory;

import java.util.Scanner;

public class Biblioteca {
    private BookCollection bookCollection = new BookCollection();

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void selectMenu() {
        System.out.print("Enter Number: ");

        Scanner menuID = new Scanner(System.in);
        int numberInput = menuID.nextInt();

        MenuFactory menuFactory = new MenuFactory(numberInput);
        Menu output = menuFactory.getMenu();
        if(output != null) {
            output.showProperty();
        } else {
            System.out.println("Please select again");
            this.selectMenu();
        }

    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.showWelcomeMessage());
        System.out.println("Please select the following menu by number");
        System.out.println("1: List of Books");
        System.out.println("2: Others");

        biblioteca.selectMenu();
    }
}
