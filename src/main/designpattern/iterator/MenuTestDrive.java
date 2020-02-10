package main.designpattern.iterator;

import main.designpattern.iterator.service.DinerMenu;
import main.designpattern.iterator.service.PanCackeHouseMenu;
import main.designpattern.iterator.service.Waitress;

import java.util.ArrayList;

/**
 * @author jitendra.kumar01
 * 09/02/20
 */
public class MenuTestDrive {
    public static void main(String[] args) {
        //PanCackeHouseMenu panCackeHouseMenu = new PanCackeHouseMenu();

        Menu panCackeHouseMenu = new PanCackeHouseMenu();

        panCackeHouseMenu.addItem("Regular PanCake Breakfast","PanCake with fried eggs ,sausage",
                                  false,2.99);
        panCackeHouseMenu.addItem("Blueberry PanCakes","PanCake made with  fresh blueberries",
                                  true,3.49);

        DinerMenu dinerMenu = new DinerMenu();
        dinerMenu.addItem("Vegetarian BLT","Beccon with letuce & tomato on whole wheat",
                          true,2.89);
        dinerMenu.addItem("HotDog","A Hot Dog with saurkraut , relish , onions , topped with cheese",
                          false,4.89);

        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(panCackeHouseMenu);
        menus.add(dinerMenu);
       // Waitress waitress = new Waitress(panCackeHouseMenu,dinerMenu);
        Waitress waitress = new Waitress(menus);
        waitress.printMenu();

    }
}
