package main.linkedlist.singly;

public class SwapTwoNode {
    public static ListNode swap(ListNode head, int a, int b) {
        if (null == head || null == head.next)
            return null;

        ListNode prev1, prev2, t1, t2, node;

        node = head;

        prev1 = prev2 = t1 = t2 = null;

        while (null != node) {

            if (node.data == a) {
                t1 = node;
                break;
            }

            prev1 = node;
            node = node.next;
        }


        while (null != node) {

            if (node.data == b) {
                t2 = node;
                break;
            }

            prev2 = node;
            node = node.next;
        }


        if (null == t1 || null == t2)
            return head;

        if (prev1 != null) {
            prev1.next = t2;
        } else {
            head = t2;
        }

        if (prev2 != null) {
            prev2.next = t1;
        } else {
            head = t1;
        }

        ListNode temp = t1.next;
        t1.next = t2.next;
        t2.next = temp;

        return head;
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.head = new ListNode(12);
        list.head.setNext(new ListNode(99));
        list.head.getNext().setNext(new ListNode(8));
        list.head.getNext().getNext().setNext(new ListNode(39));
        list.head.getNext().getNext().getNext().setNext(new ListNode(5));
        list.printList(swap(list.head, 99, 39));
    }
}
