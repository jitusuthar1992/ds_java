package main.designpattern.iterator;

import java.util.Iterator;

/**
 * @author jitendra.kumar01
 * 09/02/20
 */
public interface Menu {
    Iterator createIterator();
    void addItem(String name , String description , boolean veg , double price );
}
