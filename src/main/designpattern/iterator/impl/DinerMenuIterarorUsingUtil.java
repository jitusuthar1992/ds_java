package main.designpattern.iterator.impl;

import main.designpattern.iterator.model.MenuItem;

import java.util.Iterator;

/**
 * @author jitendra.kumar01
 * 09/02/20
 */
public class DinerMenuIterarorUsingUtil implements Iterator {

    int position = 0;
    MenuItem[] menuItems;

    public DinerMenuIterarorUsingUtil(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.length || menuItems[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem item = menuItems[position];
        position++;
        return item;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove item from menu , because menu doesn't contain any item");
        }

        if (menuItems[position - 1] != null) {
            for (int i = position - 1; i < (menuItems.length - 1); i++) {
                menuItems[i] = menuItems[i + 1];
            }
            menuItems[menuItems.length - 1] = null;
        }
    }
}
