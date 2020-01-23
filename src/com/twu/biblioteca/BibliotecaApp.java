package com.twu.biblioteca;

import com.twu.biblioteca.biblioteca.Biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Please select the following menu by number");
        System.out.println("1: List of Books");
        System.out.println("2: Others");
        System.out.print("Enter Number: ");

        Scanner menuID = new Scanner(System.in);
        int numberInput = menuID.nextInt();
        biblioteca.showMenu(numberInput);
    }
}
