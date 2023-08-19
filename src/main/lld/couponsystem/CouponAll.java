package main.lld.couponsystem;

public class CouponAll implements Coupon {
    private static final float DISCOUNT = 0.25f;
    Coupon successor;
    public void setSuccessor(Coupon successor) {
        this.successor = successor;
    }
    public void apply(Cart cart) {
        for (CartItem item : cart.getItems()) {
            item.setPrice(item.getPrice() - item.getPrice() * DISCOUNT);
        }
        if (successor != null) {
            successor.apply(cart);
        }
    }
}
