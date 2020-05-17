package main.linkedlist.singly;

public class CheckLinkedListPallindrome {
    public static Node reverseLinkedList(Node head){
        Node current =head, next = null, prev = null;
        while (null != current){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }


    public static Node findMiddleElement(Node head){
        Node fastPtr = head , slowPtr = head;

        while (null != fastPtr){
            fastPtr = fastPtr.next;
            if(fastPtr != null && fastPtr.next != null){
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        }
        return slowPtr;
    }

    public static boolean checkPallindrome(Node head){
        Node middleNode = findMiddleElement(head);
        Node secondHead= middleNode.next;

        middleNode.next = null;

        Node reverseSecondHead = reverseLinkedList(secondHead);

        while (head != null && reverseSecondHead != null){
            if(head.data == reverseSecondHead.data){
                head = head.next;
                reverseSecondHead = reverseSecondHead.next;
                continue;
            }
            return false;
        }
        return true;
    }
}
