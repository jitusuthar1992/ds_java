package main.designpattern.iterator.service;

import main.designpattern.iterator.IIterator;
import main.designpattern.iterator.Menu;
import main.designpattern.iterator.impl.PanCakeHouseMenuIterator;
import main.designpattern.iterator.model.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author jitendra.kumar01
 * 09/02/20
 */
public class PanCackeHouseMenu implements Menu {
    ArrayList<MenuItem> menuItems;

    public PanCackeHouseMenu() {
        menuItems = new ArrayList<>();
    }

    public Iterator createIterator() {
        return menuItems.iterator();
    }

    @Override
    public void addItem(String name, String description, boolean veg, double price) {
        MenuItem menuItem = new MenuItem(name, description, veg, price);
        menuItems.add(menuItem);
    }


    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
