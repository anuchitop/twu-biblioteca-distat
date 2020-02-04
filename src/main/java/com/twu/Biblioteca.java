package com.twu;

import com.twu.menu.Menu;
import com.twu.menu.MenuSelection;
import com.twu.login.Account;
import com.twu.login.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {
    private Collection collection = new Collection();

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public Menu getMenu(Integer inputNum) {
        MenuSelection menuSelection = new MenuSelection();
        return menuSelection.getMenu(inputNum);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Account> accountList = new ArrayList<>();
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        PrintStream printStream = new PrintStream(System.out);
        Account account1 = new Account("John Cena", "111-1111", "password");
        Account account2 = new Account("Peter Parker", "222-2222", "password2");
        Account account3 = new Account("Elon Mustnot", "333-3333", "password3");
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        Login login = new Login(accountList, bufferedReader, printStream);
        // TODO: Check with Aj'Nong if this is practical
//        while(com.twu.login.getCurrentAccount().equals(null)) {
//            com.twu.login.initLogin();
//        }
        login.initLogin();
    }
}
