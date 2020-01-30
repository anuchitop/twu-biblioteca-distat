package com.twu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Login {
    private ArrayList<Account> accountList;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Login(ArrayList<Account> accountList, BufferedReader bufferedReader, PrintStream printStream) {
        this.accountList = accountList;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void initLogin() {
        ;
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
        boolean validPassword = this.isInputValid("password", passwordInput);
        if (!validPassword) {
            printStream.println("Invalid Password");
            return false;
        } return true;
    }

    public boolean isInputValid(String validation, String input) {
        for (Account account:accountList) {
            if (validation.equals("libraryID") && account.getLibraryID().equals(input)) {
                return true;
            } else if (validation.equals("password") && account.getPassword().equals(input)) {
                return true;
            }
        } return false;
    }

    public ArrayList<Account> fetchAccountFromDB() {
        return accountList;
    }
}
