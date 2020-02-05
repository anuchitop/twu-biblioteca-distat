package com.twu.menu;

import java.util.ArrayList;
import java.util.List;

public class MockPrintStream implements Printer {
    public List<String> printCapture = new ArrayList<>();

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void println(String text) {
        printCapture.add(text);
    }

    @Override
    public List<String> getPrinterCapture() {
        return printCapture;
    }
}
