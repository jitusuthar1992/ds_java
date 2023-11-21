package main.java1.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBy {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", 38);
        Employee e2 = new Employee("Tim", 33);
        Employee e3 = new Employee("Andrew", 33);
        Employee e4 = new Employee("Peter", 38);
        Employee e5 = new Employee("Nathan", 22);
        Employee e6 = new Employee("George", 23);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        Map<Integer, List<Employee>> employeesByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));

        List<String> fruitNames = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Integer> fruitMap = new HashMap<>();
        for (String f : fruitNames) {
            if (fruitMap.containsKey(f)) fruitMap.put(f, fruitMap.get(f) + 1);
            else fruitMap.put(f, 1);
        }

        Map<String, Long> result = fruitNames.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       List<Item> items =  Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Integer> rs  =  items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.summingInt(Item::getQty)));

        Map<Integer, List<String>> employeeNamesByAge = employees.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.mapping(Employee::getName,Collectors.toList())));

        Map<BigDecimal, Set<String>> rst = items.stream()
                .collect(
                        Collectors.groupingBy(
                                Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        Map<BigDecimal, Set<String>> sortedItemsByPrice = items.stream()
                .collect(
                        Collectors.groupingBy(
                                Item::getPrice,
                                TreeMap::new,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        Map<Integer, Set<String>> sortedEmployeesByAge = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getAge,
                                TreeMap::new,
                                Collectors.mapping(Employee::getName, Collectors.toSet())
                        )
                );
    }

}

class Item {
    private String name;
    private int qty;
    private BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}