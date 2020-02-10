package main.designpattern.iterator.service;

import main.designpattern.iterator.IIterator;
import main.designpattern.iterator.Menu;
import main.designpattern.iterator.model.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author jitendra.kumar01
 * 09/02/20
 */
public class Waitress {

    ArrayList<Menu> menus;
    /*Menu panCackeHouseMenu;
    Menu dinerMenu;*/

   /* public Waitress(Menu panCackeHouseMenu, Menu dinerMenu) {
        this.panCackeHouseMenu = panCackeHouseMenu;
        this.dinerMenu = dinerMenu;
    }*/

    public Waitress(ArrayList<Menu> menus) {
        this.menus = menus;
    }

   /*public void printMenu(){
        Iterator panCakeItr = panCackeHouseMenu.createIterator();
        Iterator dinerItr = dinerMenu.createIterator();
        System.out.println("MENU \n---- \n BREAKFAST");
        printMenu(panCakeItr);
        System.out.println("\nLUNCH");
        printMenu(dinerItr);
    }*/

    /*public void printMenu(){
        Iterator panCakeItr = panCackeHouseMenu.createIterator();
        Iterator dinerItr = dinerMenu.createIterator();
        System.out.println("MENU \n---- \n BREAKFAST");
        printMenu(panCakeItr);
        System.out.println("\nLUNCH");
        printMenu(dinerItr);
    }*/


    public void printMenu(){
        Iterator<Menu> itr = menus.iterator();
        while (itr.hasNext()){
           Menu menu =  itr.next();
           printMenu(menu.createIterator());
        }
    }
    private void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName()+", ");
            System.out.println(menuItem.getPrice()+" -- ");
            System.out.println(menuItem.getDescription());
        }
    }


}
