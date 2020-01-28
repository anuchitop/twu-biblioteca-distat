package com.twu.biblioteca.menu;

import com.twu.biblioteca.collection.Item;


public interface ListOfItems{

    void listAllItems();

    Item selectItem(String input);

    void checkoutOrReturn(String userChoice);

    String checkoutItem(String condition);

    void returnItem(String condition);

    String userInput();

}
