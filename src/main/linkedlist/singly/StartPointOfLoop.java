package main.linkedlist.singly;

public class StartPointOfLoop {
    public static ListNode findStartPointOfLoop(ListNode head){
        ListNode slow = head, fast = head;
        while (null != slow && null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if(slow != fast)
            return null;
        slow = head;
        while (slow != fast){
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.head = new ListNode(12);
        list.head.setNext(new ListNode(99));
        list.head.getNext().setNext(new ListNode(13));
        list.head.getNext().getNext().setNext(new ListNode(5));
        list.head.getNext().getNext().getNext().setNext(new ListNode(25));
        list.head.getNext().getNext().getNext().getNext().setNext(list.head);

        // System.out.println("Linked List before removing loop : ");
        // list.printList(list.head);


        System.out.println("Start point of loop is "+ StartPointOfLoop.findStartPointOfLoop(list.head).data);

    }
}
