package com.twu.collection;

import com.twu.Item;


public interface ListOfItems{

    void listAllItems();

    Item selectItem(String input);

    void checkoutOrReturn(String userChoice);

    String checkoutItem(String condition);

    void returnItem(String condition);

    String userInput();

}
