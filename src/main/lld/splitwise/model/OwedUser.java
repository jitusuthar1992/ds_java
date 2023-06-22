package main.lld.splitwise.model;

public class OwedUser {
    private User user;
    private double balance;

    public OwedUser(User user, double balance) {
        this.user = user;
        this.balance = balance;
    }

    public OwedUser() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
