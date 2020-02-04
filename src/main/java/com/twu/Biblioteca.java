package com.twu;

import com.twu.collection.Collection;
import com.twu.login.Login;
import com.twu.menu.Menu;
import com.twu.menu.MenuSelection;
import com.twu.login.Account;

import java.io.IOException;

public class Biblioteca {
    private Collection collection = new Collection();
    private Account account;
    private Login login;

//    public Account performLogin() throws IOException {
//        login.initLogin();
//        this.account = login.getCurrentAccount();
//        return
//    }

    public void initBiblioteca() throws IOException {
        login.initLogin();
        this.account = login.getCurrentAccount();

        this.showWelcomeMessage();
        System.out.println("Welcome:  " + this.account.getName());
        MenuSelection menu = new MenuSelection();
        menu.startMenuSelection();
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public Menu getMenu(Integer inputNum) {
        MenuSelection menuSelection = new MenuSelection();
        return menuSelection.getMenu(inputNum);
    }
}
