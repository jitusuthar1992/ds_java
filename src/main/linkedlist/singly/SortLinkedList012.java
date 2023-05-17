package main.linkedlist.singly;

public class SortLinkedList012 {
    public  static Node sort1(Node head){
        if(head == null)
            return head;
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        Node curr = head;

        while (curr != null){
            if(curr.data ==0){
                zeroCount++;
            } else if (curr.data ==1) {
                oneCount++;
            } else if (curr.data ==2) {
                twoCount++;
            }
        }

        curr = head;

        while (curr != null){
            if(curr.data ==0){
                zeroCount--;
                curr.data =0;
            } else if (curr.data ==1) {
                oneCount--;
                curr.data =1;
            } else if (curr.data ==2) {
                twoCount--;
                curr.data =2;
            }
            curr = curr.next;
        }
        return head;
    }

    public  static Node sort2(Node head){
        if(head == null)
            return head;

        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node curr = head;
        while (curr != null){
            int value = curr.data;
            if(value == 0){
                insertAtTail(zeroTail,curr);
            }else if(value ==1){
                insertAtTail(oneTail,curr);
            }else {
                insertAtTail(twoTail,curr);
            }
        }

        if(oneHead.next != null){
            zeroTail.next = oneHead.next;
        }else {
            zeroTail.next = twoHead.next;
        }
        oneTail.next = twoHead.next;
        twoHead.next = null;
        head = zeroHead.next;
        return head;
    }

    private static void insertAtTail(Node tail, Node curr) {
        tail.next = curr;
        tail = curr;
    }
}
