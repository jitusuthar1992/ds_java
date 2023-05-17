package main.linkedlist.singly;

public class RotateDoublyLinkedList {
    public static DoublyLLNode rotateByN(DoublyLLNode head , int n){
        if(n ==0){
            return head;
        }
        DoublyLLNode curr = head;
        int count = 1;
        while (count < n & curr != null){
            curr = curr.next;
            count++;
        }
        DoublyLLNode nthNode = curr;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = head;
        head.prev = curr;
        head = nthNode.next;
        head.prev = null;
        nthNode.next = null;

        return head;
    }
}
