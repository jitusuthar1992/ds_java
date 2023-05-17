package main.linkedlist.singly;

public class ReverseDoublyLinkedList {
    DoublyLLNode reverseSol1(DoublyLLNode head){
        if(head == null || head.next == null)
            return head;

        DoublyLLNode curr = head;

        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = curr.prev;
        curr.prev = null;
        curr = curr.next;
        head = curr;

        while (curr.prev != null){
            DoublyLLNode temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = curr.next;
        }
        curr.prev = curr.next ;
        curr.next = null;
        return head;
    }

    DoublyLLNode reverseSol2(DoublyLLNode head){
        if(head == null || head.next == null)
            return head;

        DoublyLLNode curr = head;

        while (curr.next != null){
            curr = curr.next;
        }

        head = curr;
        while (curr!= null){
            DoublyLLNode temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = curr.next;
        }
        return head;
    }
}
