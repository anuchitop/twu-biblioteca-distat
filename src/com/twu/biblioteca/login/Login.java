package com.twu.biblioteca.login;

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

    public String verifyUsernameInput() throws IOException {
        String libraryID = bufferedReader.readLine();
        boolean validFormat = libraryID.matches("[0-9]{3}-[0-9]{4}");
        boolean accountExist = this.isUserExist(libraryID);
        if (!validFormat) {
            printStream.println("Invalid Username Format");
            return "Not Cool Man";
        } else if (!accountExist){
            printStream.println("User not existed");
            return "Not Cool Again Man";
        } else {
            return "SO GOOD MAN";
        }
    }

    public String verifyPasswordInput() {
        return "SHIT";
    }

    public boolean isUserExist(String libraryID) {
        for (Account account:accountList) {
            if (account.getLibraryID().equals(libraryID)) {
                return true;
            }
        } return false;
    }

    public ArrayList<Account> fetchAccountFromDB() {
        return accountList;
    }
}
