package com.twu.login;

import com.twu.Biblioteca;
import com.twu.menu.MenuSelection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Login {
    private ArrayList<Account> accountList;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Account currentAccount;

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Login(ArrayList<Account> accountList, BufferedReader bufferedReader, PrintStream printStream) {
        this.accountList = accountList;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        setCurrentAccount(null);
    }

    public void initLogin() throws IOException {
        System.out.println("Username: ");
        while(!this.verifyUsernameInput()) {
            System.out.println("Please enter username again:");
        }
        System.out.println("Password: ");
        while(!this.verifyPasswordInput()) {
            System.out.println("Please enter password again:");
        }

        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.showWelcomeMessage());
        System.out.println("Welcome "+currentAccount.getName());
        MenuSelection menu = new MenuSelection();
        menu.startMenuSelection();
    }

    public boolean verifyUsernameInput() throws IOException {
        String libraryIDInput = bufferedReader.readLine();
        boolean validFormat = libraryIDInput.matches("[0-9]{3}-[0-9]{4}");
        boolean accountExist = this.isInputValid("libraryID", libraryIDInput);
        if (!validFormat) {
            printStream.println("Invalid Username Format");
            return false;
        } else if (!accountExist){
            printStream.println("User not existed");
            return false;
        } return true;
    }

    public boolean verifyPasswordInput() throws IOException {
        String passwordInput = bufferedReader.readLine();
        boolean validPassword = this.isPasswordInputInDB(passwordInput);
        if (!validPassword) {
            printStream.println("Invalid Password");
            return false;
        } return true;
    }

    public boolean isInputValid(String validation, String input) {
        for (Account account:accountList) {
            if (validation.equals("libraryID") && account.getLibraryID().equals(input)) {
                this.currentAccount = account;
                return true;
            }
        } return false;
    }

    public boolean isPasswordInputInDB(String input) {
        if (currentAccount.getPassword().equals(input)) {
            System.out.println(currentAccount.getName());
            System.out.println("Password Checked");
            return true;
        } return false;
    }

    public ArrayList<Account> fetchAccountFromDB() {
        return accountList;
    }
}
