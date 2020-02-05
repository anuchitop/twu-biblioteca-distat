package com.twu.menu;

import java.io.IOException;

public interface Menu {
    MenuSelection menu = new MenuSelection();
    void showMenuProperty() throws IOException;
}
