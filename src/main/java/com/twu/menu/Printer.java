package com.twu.menu;

import java.util.List;

public interface Printer {
    void print(String text);
    void println(String text);
    List<String> getPrinterCapture();
}
