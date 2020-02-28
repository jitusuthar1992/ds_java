package main.java1.java8;

import java.util.Optional;

/**
 * @author jitendra.kumar01
 * 27/01/20
 */
public class OptionalsExample {
    public static void main(String[] args) {
        Optional<Integer> optionalInteger = Optional.of(5);
        optionalInteger.ifPresent(System.out::println);
        System.out.println(optionalInteger.isPresent());
        if(optionalInteger.isPresent()){
            System.out.println(optionalInteger.get());
        }


        Optional<Integer> emptyOptional = Optional.empty();
        emptyOptional.ifPresent(System.out::println);

        System.out.println(emptyOptional.isPresent());


        Optional<Integer> possible = Optional.ofNullable(null);

        Integer i = possible.orElse(7);
        System.out.println(i);

        Optional<Integer> possible1 = Optional.ofNullable(6);

        possible1.ifPresent(System.out::println);


    }
}
