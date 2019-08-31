package main.java1;

public class SwitchWithoutBreak {
    public static void main(String[] args) {
        String str = "x";
        switch (str){
            case "x":
                System.out.println(str);
                case "y":
                System.out.println("y");
        }
    }
}
