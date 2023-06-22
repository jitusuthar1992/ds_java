package main.lld.splitwise.constant;

import java.util.HashMap;

public enum ExpenseType {
    EQUAL("EQUAL"),
    EXACT ("EXACT"),
    PERCENT("PERCENT");

    private final String expense;

    ExpenseType(String s) {
        expense = s;
    }

    public String toString() {
        return this.expense;
    }

    private static final HashMap<String, ExpenseType> map = new HashMap<>(values().length, 1);

    static {
        for (ExpenseType c : values()) map.put(c.expense, c);
    }

    public static ExpenseType of(String name){
        return map.get(name);
    }

    public enum Type {
        EXPENSE ("EXPENSE"),
        SHOW ("SHOW"),
        QUIT ("QUIT");

        private final String name;

        Type(String s) {
            name = s;
        }

        public String toString() {
            return this.name;
        }

        private static final HashMap<String, Type> map = new HashMap<>(values().length, 1);

        static {
            for (Type c : values()) map.put(c.name, c);
        }

        public static Type of(String name){
            return map.get(name);
        }
    }
}
