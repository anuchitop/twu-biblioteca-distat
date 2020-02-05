package com.twu;

import com.twu.login.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader bufferedReader = new BufferedReader(reader);

    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream(System.out);
        Login login = new Login(bufferedReader, printStream);

        Biblioteca app = new Biblioteca(bufferedReader, printStream);
        app.startApplication();
    }

}
