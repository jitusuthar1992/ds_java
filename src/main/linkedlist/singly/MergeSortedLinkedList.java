package main.linkedlist.singly;

public class MergeSortedLinkedList {
    static ListNode merge(ListNode head1, ListNode head2) {

        ListNode headNew = null, s = null;

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        if (head1.data <= head2.data) {
            s = head1;
            head1 = s.next;
        } else {
            s = head2;
            head2 = s.next;
        }
        headNew = s;

        while (null != head1 && null != head2) {
            if (head1.data <= head2.data) {
                s.next = head1;
                s = head1;
                head1 = s.next;
            } else {
                s.next = head2;
                s = head2;
                head2 = s.next;
            }
        }
        if (head1 == null) {
            s.next = head2;
        }
        if (head2 == null) {
            s.next = head1;
        }
        return headNew;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static ListNode mergeRecursion(ListNode head1, ListNode head2) {

        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.data < head2.data) {
            head1.next = mergeRecursion(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeRecursion(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.head = new ListNode(1);
        list1.head.next = new ListNode(3);
        list1.head.next.next = new ListNode(5);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.head = new ListNode(0);
        list2.head.next = new ListNode(2);
        list2.head.next.next = new ListNode(4);

        MergeSortedLinkedList.printList(mergeRecursion(list1.head, list2.head));

    }
}
