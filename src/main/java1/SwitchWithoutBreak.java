package main.java1;

import java.io.File;

public class SwitchWithoutBreak {
    public static void main(String[] args) {


        String str = "x";

        /*switch (str){
            case "x":
            case "y":
                String s1 = str;
                System.out.println(str);
                break;
            case "z":
                s1 = str;
                System.out.println(str);
                break;
        }*/
        switch (str) {
            case "x":
                System.out.println(str);
            case "y":
                System.out.println("y");
        }
    }
}
