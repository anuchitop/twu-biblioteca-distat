package com.twu.menu;

import com.twu.menu.Menu;

public class QuitApplication implements Menu {
    public static void quit() {
        System.exit(0);
    }


    @Override
    public void showMenuProperty() {
        System.exit(0);
    }
}
