package main.java1.function;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Function<String, String> function = input -> input.toUpperCase();
        System.out.println(function.apply("wwwww"));
    }
}
