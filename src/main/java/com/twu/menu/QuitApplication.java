package com.twu.menu;

import com.twu.menu.Menu;

public class QuitApplication implements Menu {
    @Override
    public void showMenuProperty() {
        System.exit(0);
    }
}
