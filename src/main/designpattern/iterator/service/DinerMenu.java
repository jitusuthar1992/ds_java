package main.designpattern.iterator.service;

import main.designpattern.iterator.IIterator;
import main.designpattern.iterator.Menu;
import main.designpattern.iterator.impl.DinerMenuIterarorUsingUtil;
import main.designpattern.iterator.impl.DinerMenuIterator;
import main.designpattern.iterator.model.MenuItem;

import java.util.Iterator;

/**
 * @author jitendra.kumar01
 * 09/02/20
 */
public class DinerMenu implements Menu {
    final  int MAX_ITEMS =6 ;
    int numberOfItems = 0 ;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
    }

    @Override
    public void addItem(String name , String description , boolean veg , double price ){
        MenuItem menuItem = new MenuItem(name,description,veg,price);
        if(numberOfItems >= MAX_ITEMS){
            System.err.println("Sorry , menu is full ! Can't add item to menu ");
        }else{
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }


  /*  public IIterator createIterator(){
        return  new DinerMenuIterator(menuItems);
    }*/

    @Override
    public Iterator createIterator(){
        return  new DinerMenuIterarorUsingUtil(menuItems);
    }


    public int getNumberOfItems() {
        return numberOfItems;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }
}
