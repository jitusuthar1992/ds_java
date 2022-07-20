package main.designpattern.iterator.impl;

import main.designpattern.iterator.IIterator;
import main.designpattern.iterator.model.MenuItem;

import java.util.ArrayList;

/**
 * @author jitendra.kumar01
 * 09/02/20
 */
public class PanCakeHouseMenuIterator implements IIterator {

    private int postion = 0;
    private ArrayList<MenuItem> menuItems;

    public PanCakeHouseMenuIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (postion >= menuItems.size() || menuItems.get(postion) == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem item = menuItems.get(postion);
        postion++;
        return item;
    }
}
