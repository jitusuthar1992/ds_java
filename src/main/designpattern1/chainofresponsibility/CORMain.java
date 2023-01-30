package main.designpattern1.chainofresponsibility;

public class CORMain {
    public static void main(String[] args) {
        Manager manager = new ChainCreator().createChain();
        manager.approveSalary(700000);
        manager.approveSalary(1500000);
        manager.approveSalary(3000000);
        manager.approveSalary(6000000);
    }
}
