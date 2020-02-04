package com.twu.login;

import com.twu.Biblioteca;
import com.twu.menu.MenuSelection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Login {
    private ArrayList<Account> accountList = new ArrayList<>();
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Account currentAccount;

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Login(BufferedReader bufferedReader, PrintStream printStream) {
        this.fetchAccountListFromDB();
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        setCurrentAccount(null);
    }

    public void initLogin() throws IOException {
        this.verifyUsernameAndPassword();
    }

    public void verifyUsernameAndPassword() throws IOException {
        System.out.println("LibraryID: ");
        while (!this.verifyLibraryIDInput()) {
            System.out.println("Please enter LibraryID again:");
        }
        System.out.println("Password: ");
        while (!this.verifyPasswordInput()) {
            System.out.println("Please enter password again:");
        }
    }

    // ================ LibraryID Verification Section ================ //

    public Boolean verifyLibraryIDInput() throws IOException {
        String libraryIDInput = this.input();
        return this.isLibraryIDInputValid(libraryIDInput);
    }

    public Boolean isLibraryIDInputValid(String libraryIDInput) {
        boolean validFormat = this.isInputFormatCorrect(libraryIDInput);
        boolean accountExist = this.isLibraryIDExisted(libraryIDInput);

        if (validFormat && accountExist) {
            return true;
        } else if (!validFormat) {
            printStream.println("Invalid Username Format");
            return false;
        } else {
            printStream.println("User not existed");
            return false;
        }
    }

    public Boolean isInputFormatCorrect(String libraryIDInput) {
        return libraryIDInput.matches("[0-9]{3}-[0-9]{4}");
    }

    public Boolean isLibraryIDExisted(String libraryIDInput) {
        for (Account account : accountList) {
            if (account.getLibraryID().equals(libraryIDInput)) {
                this.currentAccount = account;
                return true;
            }
        }
        return false;
    }

    // ================ Password Verification Section ================ //

    public Boolean verifyPasswordInput() throws IOException {
        String passwordInput = this.input();
        return isPasswordInputInDB(passwordInput);
    }

    public Boolean isPasswordInputInDB(String input) {
        boolean passwordMatchesLibraryID = currentAccount.getPassword().equals(input);
        if (!passwordMatchesLibraryID) {
            printStream.println("Invalid Password");
            return false;
        }
        return true;
    }

    public void fetchAccountListFromDB() {
        Account account1 = new Account("John Cena", "111-1111", "password");
        Account account2 = new Account("Peter Parker", "222-2222", "password2");
        Account account3 = new Account("Elon Mustnot", "333-3333", "password3");
        this.accountList.add(account1);
        this.accountList.add(account2);
        this.accountList.add(account3);
    }

    public String input() throws IOException {
        return bufferedReader.readLine();
    }
}
