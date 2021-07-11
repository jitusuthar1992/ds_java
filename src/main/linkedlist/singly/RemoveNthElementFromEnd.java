package main.linkedlist.singly;

/**
 * @author jitendra.kumar01
 * 07/02/20
 */
public class RemoveNthElementFromEnd {
    public static void removeNthNodeFromEnd(int n , ListNode head , SinglyLinkedList list){
        ListNode temp1 = head , temp2 = head;
        int count =0;
        ListNode prev = null;

        while(temp2 != null){
            count++;
            if(count > n){
                prev =temp1;
                temp1 = temp1.next;
            }
            temp2 = temp2.next;
        }

        prev.next = temp1.next;

    }

    public static void removeNthNodeFromEndSol1(int n , ListNode head , SinglyLinkedList list){
        ListNode temp1 = head , temp2 = head;

        for (int i = 0; i <n ; i++) {
            if(temp2.next == null){
                if(i == n-1)
                    head = head.next;
                return;
            }
           temp2 = temp2.next;
        }

        while (temp2.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1.next = temp1.next.next;

    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.head = new ListNode(50);
        list.head.setNext(new ListNode(20));
        list.head.getNext().setNext(new ListNode(15));
        list.head.getNext().getNext().setNext(new ListNode(4));
        list.head.getNext().getNext().getNext().setNext(new ListNode(10));

        System.out.println("Linked List before removing element : ");
        list.printList(list.head);

        System.out.println("Linked List after removing element : ");

        removeNthNodeFromEnd(4 ,  list.head , list);


    }
}
