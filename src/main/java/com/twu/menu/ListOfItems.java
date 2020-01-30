package main.java.com.twu.menu;

import main.java.com.twu.Item;


public interface ListOfItems{

    void listAllItems();

    Item selectItem(String input);

    void checkoutOrReturn(String userChoice);

    String checkoutItem(String condition);

    void returnItem(String condition);

    String userInput();

}
