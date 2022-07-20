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
}
