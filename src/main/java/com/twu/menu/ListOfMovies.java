package com.twu.menu;

import com.twu.collection.Movies;
import com.twu.collection.Collection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListOfMovies implements Menu {
    private BufferedReader bufferedReader;
    private Printer printStream;
    private Collection collection;
    private Movies selectedMovies;

    public Movies getSelectedMovies() {
        return selectedMovies;
    }

    public ListOfMovies() {
        collection = new Collection();
        this.printStream = new PrinterImpl();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public ListOfMovies(Printer printStream, BufferedReader bufferedReader) {
        collection = new Collection();
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void property() throws IOException {
        printStream.println("=============== List of Movies ===============");
        listAllMovies();
        printStream.println("=============================================");
        checkoutOrReturn();
    }

    public void listAllMovies() {
        for (Movies Movies : collection.getMoviesList()) {
            printStream.println(Movies.toString());
        }
    }

    public Movies selectMovies() throws IOException {
        printStream.println("Please select the Movies: ");
        Integer MoviesID = Integer.parseInt(userInput());
        this.selectedMovies = listOfMoviesFromCollections().get(MoviesID - 1);
        return this.selectedMovies;
    }

    public void checkoutOrReturn() throws IOException {
        printStream.println("Do you want to 1) Checkout or 2) Return or 3) Back to Main Menu");
        printStream.print(">>> ");
        Integer userChoice = Integer.parseInt(userInput());
        switch (userChoice) {
            case 1:
                selectMovies();
                doCheckout();
                break;
            case 2:
                selectMovies();
                doReturn();
                break;
            case 3:
                menu.startMenuSelection();
                break;
            default:
                printStream.println("Invalid, Please fill again");
                this.property();
                break;
        }
    }

    // ===================== Checkout ===================== //
    public void doCheckout() throws IOException {
        checkoutItem();
        confirmCheckOut();
        // Back to main property
        property();
    }

    public void checkoutItem() {
        printStream.println(selectedMovies.toString());
        printStream.println("Do you wish to checkout this Movies (Y/N) ?");
    }

    public void confirmCheckOut() throws IOException {
        Boolean userConfirmation = confirm();
        if (!userConfirmation || !this.selectedMovies.getIsAvailable()) {
            printStream.println("Invalid Checkout");
        } else {
            this.selectedMovies.setAvailable(false);
            printStream.println("You have checkout " + this.selectedMovies);
        }
    }
    // ==================================================== //


    // ===================== Return ===================== //

    public void doReturn() throws IOException {
        returnItem();
        confirmReturn();
        // Back to main property
        property();
    }
    public void returnItem() {
        printStream.println(selectedMovies.toString());
        printStream.println("Do you wish to return this Movies (Y/N) ?");
    }

    public void confirmReturn() throws IOException {
        Boolean userConfirmation = confirm();
        if (!userConfirmation || this.selectedMovies.getIsAvailable()) {
            printStream.println("Invalid Return");
        } else {
            this.selectedMovies.setAvailable(true);
            printStream.println("You have return " + this.selectedMovies);
        }
    }

    // ==================================================== //


    public String userInput() throws IOException {
        return bufferedReader.readLine();
    }

    public Boolean confirm() throws IOException {
        String userInput = userInput();
        return userInput.equals("Y");
    }


    public ArrayList<Movies> listOfMoviesFromCollections() {
        return this.collection.getMoviesList();
    }

    @Override
    public void showMenuProperty() throws IOException {
        this.property();
    }
}
