package main.java1.function;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return   input.toUpperCase();
            }
        };
        System.out.println(function.apply("wwwww"));
    }



}
