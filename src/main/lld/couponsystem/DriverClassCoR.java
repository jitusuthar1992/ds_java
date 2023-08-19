package main.lld.couponsystem;

public class DriverClassCoR {
    public static void main(String[] args) {
        Product card1 = new Card("Card", 12.99);
        Product card2 = new Card("Card", 12.99);
        Product card3 = new Card("Card", 12.99);
        Product tshirt1 = new Tshirt("Tshirt", 24.99);
        Product tshirt2 = new Tshirt("Tshirt", 24.99);
        Product backPack1 = new BackPack("BackPack", 34.99);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(card1);
        cart.addItem(card2);
        cart.addItem(card3);
        Coupon couponAll = new CouponAll();
        cart.addItem(tshirt1);
        Coupon couponNext = new CouponNext(cart.getItems().size());
        couponAll.setSuccessor(couponNext);
        Coupon couponNextBackPack;
        couponNextBackPack = new CouponNextBackPack(cart.getItems().size(),  BackPack.class);
        couponNext.setSuccessor(couponNextBackPack);
        cart.addItem(tshirt2);
        cart.addItem(backPack1);
        System.out.println("Total car value before discounts \t" +cart.totalCartValue());
        couponAll.apply(cart);
        //System.out.println(backPack1.getClass().isInstance(backPack1));
        System.out.println("Total car value after discounts \t" +cart.totalCartValue());
    }
}
