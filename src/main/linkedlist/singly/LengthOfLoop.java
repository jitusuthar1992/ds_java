package main.linkedlist.singly;

public class LengthOfLoop {
    public static int lengthOfLoop(ListNode node) {
        int length = 0;

        ListNode slow, fast;
        slow = fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data == fast.data) {
                break;
            }
        }


        if (slow == fast) {
            while (slow.next != fast) {
                slow = slow.next;
                length++;
            }
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.head = new ListNode(50);
        list.head.setNext(new ListNode(20));
        list.head.getNext().setNext(new ListNode(15));
        list.head.getNext().getNext().setNext(new ListNode(4));
        list.head.getNext().getNext().getNext().setNext(new ListNode(10));
        list.head.getNext().getNext().getNext().getNext().setNext(list.head.getNext().getNext());

        System.out.println("Length of Loop : " + lengthOfLoop(list.head));

    }
}
