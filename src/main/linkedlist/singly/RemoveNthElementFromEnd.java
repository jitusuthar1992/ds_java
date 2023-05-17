package main.linkedlist.singly;

/**
 * @author jitendra.kumar01
 * 07/02/20
 */
public class RemoveNthElementFromEnd {
    public static void removeNthNodeFromEnd(int n, ListNode head, SinglyLinkedList list) {
        ListNode temp1 = head, temp2 = head;
        int count = 0;
        ListNode prev = null;

        while (temp2 != null) {
            count++;
            if (count > n) {
                prev = temp1;
                temp1 = temp1.next;
            }
            temp2 = temp2.next;
        }

        prev.next = temp1.next;

    }

    public static ListNode removeKthNode(ListNode head, int k)
    {
        ListNode first = head, second = head , prev = null;

        for (int i = 0; i < k && first != null; i++) {
            first = first.next;
            if(first == null && i != k-1){
                return null;
            }
        }

        while (first != null) {
            first = first.next;
            prev = second;
            second = second.next;

        }
        if(second == head){
            head = head.next;
        }else {
            prev.next = second.next;
        }

        return head;
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.head = new ListNode(1);
        list.head.setNext(new ListNode(2));
        list.head.getNext().setNext(new ListNode(3));
        list.head.getNext().getNext().setNext(new ListNode(4));
        list.head.getNext().getNext().getNext().setNext(new ListNode(5));

        System.out.println("Linked List before removing element : ");
        list.printList(list.head);
        System.out.println();


        list.head  = removeKthNode(list.head, 5);

        list.printList(list.head);
    }
}
