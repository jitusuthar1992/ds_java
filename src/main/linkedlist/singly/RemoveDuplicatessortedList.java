package main.linkedlist.singly;

/**
 * @author jitendra.kumar01
 * 21/11/19
 */
public class RemoveDuplicatessortedList {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new ListNode(10);
        list.head.next = new ListNode(11);
        list.head.next.next = new ListNode(11);
        list.head.next.next.next = new ListNode(12);
        list.head.next.next.next.next = new ListNode(13);
        list.head.next.next.next.next.next = new ListNode(13);
        list.head.next.next.next.next.next.next = new ListNode(14);

        printList(list.head);
        removeDuplicates1(list.head);
        printList(list.head);

    }

    private static void removeDuplicates(ListNode head) {

        ListNode curr = head, temp = null;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                temp = curr.next.next;
                if (temp == null) {
                    curr.next = null;
                    break;
                }
                curr.next = temp;
            }
            if (curr.data != curr.next.data) {
                curr = curr.next;
            }
        }
    }


    private static void removeDuplicates1(ListNode head) {

        ListNode root = head;

        while (root.next != null) {
            if (root.data == root.next.data) {
                root.next = root.next.next;
            } else
                root = root.next;
        }
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
