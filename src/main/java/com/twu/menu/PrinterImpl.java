package com.twu.menu;

import java.util.List;

public class PrinterImpl implements Printer{
    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void println(String text) {
        System.out.println(text);
    }

    @Override
    public List<String> getPrinterCapture() {
        return null;
    }
}
