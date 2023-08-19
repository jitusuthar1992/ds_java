package main.lld.couponsystem;

public abstract class Product implements CartItem {
    String name;
    double price;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
