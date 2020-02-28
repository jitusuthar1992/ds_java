package main.designpattern.iterator.impl;

import main.designpattern.iterator.IIterator;
import main.designpattern.iterator.model.MenuItem;

/**
 * @author jitendra.kumar01
 * 09/02/20
 */
public class DinerMenuIterator implements IIterator {
    int position = 0;
    MenuItem[] menuItems;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(position >= menuItems.length || menuItems[position] == null ){
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
}
