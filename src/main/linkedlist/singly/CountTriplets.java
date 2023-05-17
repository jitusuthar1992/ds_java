package main.linkedlist.singly;

public class CountTriplets {

    public static int countTriplets(DoublyLLNode head , int sum){
        if(head == null)
            return 0;
        DoublyLLNode first , last;
        int count = 0;
        last = head;
        while (last.next != null){
            last = last.next;
        }

        for (DoublyLLNode curr = head;curr != null; curr = curr.next){
            first = curr.next;
            count += countPairs(first,last,sum-curr.data);
        }
        return count;
    }

    private static int countPairs(DoublyLLNode first, DoublyLLNode second, int value) {
        int count = 0;
        while (first != null && second != null && first != second && second.next != first){
            if((first.data+ second.data) == value){
                count++;
                first = first.next;
                second = second.prev;
            } else if ((first.data+ second.data) < value) {
                first = first.next;
            }else {
                second = second.prev;
            }
        }
        return count;
    }
}
