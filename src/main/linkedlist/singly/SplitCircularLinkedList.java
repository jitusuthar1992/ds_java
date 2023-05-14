package main.linkedlist.singly;

public class SplitCircularLinkedList {
    void split(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != head && fast.next != head){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h1 = head;
        ListNode h2 = fast;
        slow.next =h1;

        ListNode curr = h2;

        while (curr.next != head){
            curr = curr.next;
        }
        curr.next = h2;

    }
}
