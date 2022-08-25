package main.linkedlist.singly;

public class ReverseLinkedListInGroup {
    public static ListNode reverse(ListNode head,int k) {
        ListNode prev = null, next = null, current = head;
        int c= 0;
        while (null != current && c < k) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            c++;
        }
        if(null != next){
            head.setNext(reverse(next,k));
        }
        return prev;
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new ListNode(50);
        list.head.setNext(new ListNode(20));
        list.head.getNext().setNext(new ListNode(15));
        list.head.getNext().getNext().setNext(new ListNode(4));
        list.head.getNext().getNext().getNext().setNext(new ListNode(10));



        System.out.println("Linked List after reverse : ");
        list.printList(ReverseLinkedListInGroup.reverse(list.head,2));
    }
}
