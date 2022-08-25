package main.linkedlist.singly;

import java.util.HashSet;

/**
 * @author jitendra.kumar01
 * 20/11/19
 */
public class RemoveDuplicatesUnsortedList {


    static void removeDuplicates(ListNode head) {
        ListNode curr = head, prev = null;

        HashSet<Integer> hs = new HashSet<>();

        while (curr != null) {
            if (hs.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                hs.add(curr.data);
                prev = curr;
            }

            curr = prev.next;
        }
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new ListNode(10);
        list.head.next = new ListNode(12);
        list.head.next.next = new ListNode(11);
        list.head.next.next.next = new ListNode(11);
        list.head.next.next.next.next = new ListNode(12);
        list.head.next.next.next.next.next = new ListNode(11);
        list.head.next.next.next.next.next.next = new ListNode(10);

        printList(list.head);
        removeDuplicates(list.head);
        printList(list.head);

    }

}
