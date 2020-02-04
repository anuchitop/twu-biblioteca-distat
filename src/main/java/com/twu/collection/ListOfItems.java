package com.twu.collection;


public interface ListOfItems{

    void listAllItems();

    Item selectItem(String input);

    void checkoutOrReturn(String userChoice);

    String checkoutItem(String condition);

    void returnItem(String condition);

    String userInput();

}
