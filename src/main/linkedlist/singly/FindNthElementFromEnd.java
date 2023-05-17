package main.linkedlist.singly;

public class FindNthElementFromEnd {
    public static Node findNthElement(Node head, int n) {
        Node firsrPtr = head, secondPtr = head;

        for (int i = 0; i < n; i++) {
            firsrPtr = firsrPtr.next;
        }

        while (null != firsrPtr) {
            firsrPtr = firsrPtr.next;
            secondPtr = secondPtr.next;
        }

        return secondPtr;
    }
    public static ListNode findKthNode(ListNode head, int k)
    {
        ListNode first = head, second = head , prev = null;

        for (int i = 0; i < k && first != null; i++) {
            first = first.next;
            if(first == null && i != k-1){
                return new ListNode(-1);
            }
        }

        while (first != null) {
            first = first.next;
            second = second.next;

        }
        return second;
    }

    public int findNthNode(ListNode node ,int k){
        if(node == null){
            return 0;
        }
        int count = findNthNode(node.next,k);
        if(count == k){
            System.out.println("k'th node from the end is " + node.data);
        }
        return 0;
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


        ListNode kthNode  = findKthNode(list.head, 5);

        System.out.println("Kth node "+kthNode.data);

    }

}
