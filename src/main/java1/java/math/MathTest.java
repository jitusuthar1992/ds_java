package main.java1.java.math;

public class MathTest {
    public static void main(String[] args) {

        // Math.abs(param) return positive value of the parameter
        System.out.println(Math.abs(10));
        System.out.println(Math.abs(-10));
        System.out.println(Math.abs(-10.7));
        System.out.println(Math.abs(10.7));


        // Math.ceil() function rounds a floating point value up to the nearest integer value
        System.out.println(Math.ceil(7.343));
        System.out.println(Math.ceil(0.343));


        //Math.floor() function rounds a floating point value down to the nearest integer value
        System.out.println(Math.floor(7.343));
        System.out.println(Math.floor(0.343));

        //Math.round() method rounds a float or double to the nearest integer using normal math round rules (either up or down)
        System.out.println(Math.round(7.343));
        System.out.println(Math.round(0.543));
    }
}


