package com.twu.biblioteca.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuSelection {
    private Map<Integer, Menu> menuMap = new HashMap<>();
    private List<Integer> keyList = new ArrayList<Integer>(menuMap.keySet());

    public MenuSelection() {

        this.menuMap.put(1, new ListOfBooks());
        this.menuMap.put(2, new Others());

    }

    public Menu getMenu(Integer menuID) {
        if (menuMap.keySet().contains(menuID)) {
            return menuMap.get(menuID);
        } else {
            return null;
        }
    }
}
