package com.twu;

import com.twu.collection.Collection;
import com.twu.login.Login;
import com.twu.menu.Menu;
import com.twu.menu.MenuSelection;
import com.twu.login.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Biblioteca {
    private Account account;
    private Login login;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Collection collection = new Collection();
    private MenuSelection menu;

    public Biblioteca(BufferedReader bufferedReader, PrintStream printStream) {
        menu = new MenuSelection();
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void startApplication() throws IOException {
        this.performLogin();
        this.showWelcomeMessage();
        this.initBibliotecaWithLoggedInAccount();
        this.startMenuSelection();
    }

    private void performLogin() throws IOException {
        login = new Login(bufferedReader, printStream);
        login.initLogin();
        this.setAccount(login.getCurrentAccount());
    }

    private void showWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void initBibliotecaWithLoggedInAccount() {
        printStream.println("Welcome: " + this.account.getName());
    }

    public void startMenuSelection() throws IOException {
        menu.startMenuSelection();
    }

    public Menu getMenu(Integer inputNum) {
        MenuSelection menuSelection = new MenuSelection();
        return menuSelection.getMenuByInput(inputNum);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
