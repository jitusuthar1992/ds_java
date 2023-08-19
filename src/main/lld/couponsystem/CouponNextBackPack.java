package main.lld.couponsystem;

public class CouponNextBackPack implements Coupon {
    private static final float DISCOUNT = 0.15f;
    private int discountItemStartIndex;
    Coupon successor;
    Class<?> productType;
    CouponNextBackPack(int discountItemStartIndex ,Class<?> productType)    {
        this.discountItemStartIndex = discountItemStartIndex;
        this.productType = productType;
    }
    public void setSuccessor(Coupon successor) {
        this.successor = successor;
    }
    public void apply(Cart cart) {
        if (discountItemStartIndex < cart.getItems().size()) {
            for (int i = discountItemStartIndex; i <  cart.getItems().size(); ++i) {
                CartItem cartItem = cart.getItems().get(i);
                if(productType.isInstance(cartItem))    {
                    cartItem.setPrice(cartItem.getPrice() - cartItem.getPrice() * DISCOUNT);
                    break;
                }
            }
        }
        if (successor != null) {
            successor.apply(cart);
        }
    }
}
