package main.lld.vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

    private Inventory<Coin> cashInventory = new Inventory<>();
    private Inventory<Item> itemInventory = new Inventory<>();
    private long totalSales;
    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl() {
        initialize();
    }

    private void initialize() {
        //initialize machine with 5 coins of each denomination
        //and 5 cans of each Item
        for (Coin c : Coin.values()) {
            cashInventory.put(c, 5);
        }

        for (Item i : Item.values()) {
            itemInventory.put(i, 5);
        }

    }

    @Override
    public long selectItemAndGetPrice(Item item) {
        if (itemInventory.hasItem(item)) {
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Sold Out, Please buy another item");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();

        List<Coin> change = collectChange();

        return new Bucket<>(item, change);
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    private Item collectItem() throws NotSufficientChangeException,
            NotFullPaidException {
        if (isFullPaid()) {
            if (hasSufficientChange()) {
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not Sufficient change in \n" +
                    "Inventory");

        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : ",
                remainingBalance);
    }

    private List<Coin> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    private boolean isFullPaid() {
        if (currentBalance >= currentItem.getPrice()) {
            return true;
        }
        return false;
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.EMPTY_LIST;

        if (amount > 0) {
            changes = new ArrayList<>();
            long balance = amount;
            while (balance > 0) {
                if (balance >= Coin.QUARTER.getDenomination()
                        && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();

                } else if (balance >= Coin.DIME.getDenomination()
                        && cashInventory.hasItem(Coin.DIME)) {
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();

                } else if (balance >= Coin.NICKLE.getDenomination()
                        && cashInventory.hasItem(Coin.NICKLE)) {
                    changes.add(Coin.NICKLE);
                    balance = balance - Coin.NICKLE.getDenomination();

                } else if (balance >= Coin.PENNY.getDenomination()
                        && cashInventory.hasItem(Coin.PENNY)) {
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();

                } else {
                    throw new NotSufficientChangeException("NotSufficientChange,\n" +
                            "                            Please try another product");
                }
            }
        }
        return changes;
    }

    public void printStats() {
        System.out.println("Total Sales : " + totalSales);
        System.out.println("Current Item Inventory : " + itemInventory);
        System.out.println("Current Cash Inventory : " + cashInventory);
    }

    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private boolean hasSufficientChangeForAmount(long amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return false;
        }

        return hasChange;
    }

    private void updateCashInventory(List<Coin> change) {
        for (Coin c : change) {
            cashInventory.deduct(c);
        }
    }

    public long getTotalSales() {
        return totalSales;
    }
}
