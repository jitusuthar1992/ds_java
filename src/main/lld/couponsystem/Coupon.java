package main.lld.couponsystem;

public interface Coupon {
    void apply(Cart cart);
    void setSuccessor(Coupon successor);
}
