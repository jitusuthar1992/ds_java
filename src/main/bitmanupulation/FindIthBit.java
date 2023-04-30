package main.bitmanupulation;

public class FindIthBit {
    public static void findIthBit(int num, int noOfBit){
        int mask = 1 << noOfBit;
        int n = num & mask;
        if(n >0){
            System.out.println(noOfBit +"th bit of "+num+ " is 1");
        }else {
            System.out.println(noOfBit +"th bit of "+num+ " is 0");

        }

    }

    public static void main(String[] args) {
        FindIthBit.findIthBit(309,6);
    }
}
