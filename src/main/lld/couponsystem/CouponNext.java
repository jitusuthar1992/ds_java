package main.lld.couponsystem;

public class CouponNext implements Coupon {
    private static final float DISCOUNT = 0.10f;
    private int discountItemIndex;
    Coupon successor;
    CouponNext(int discountItemIndex)   {
        this.discountItemIndex = discountItemIndex;
    }
    public void setSuccessor(Coupon successor) {
        this.successor = successor;
    }
    public void apply(Cart cart) {
        if(discountItemIndex < cart.getItems().size())  {
            CartItem cartItem = cart.getItems().get(discountItemIndex);
            cartItem.setPrice(cartItem.getPrice() - cartItem.getPrice() * DISCOUNT);
        }
        if (successor != null) {
            successor.apply(cart);
        }
    }
}
