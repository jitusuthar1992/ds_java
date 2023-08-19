package main.lld.couponsystem;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart implements Cart {
    private List<CartItem> items = new ArrayList<>();
    boolean addItem(CartItem item) {
        return items.add(item);
    }
    boolean removeItem(CartItem item) {
        items.remove(item);
        return true;
    }
    public List<CartItem> getItems() {
        return items;
    }

    public double totalCartValue() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}