package main.stack;

public class MiddleElement {

    private static class Node {
        Node next ;
        Node prev;
        int data;

        public Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    Node dummy = new Node(-1);
    Node head = dummy;
    Node mid = dummy;
    int cnt =0;

    void push(int data){
        Node curr = new Node(data);
        curr.prev = null;
        curr.next=head;
        cnt++;
        head.prev = curr;
        head = curr;
        if(cnt ==1){
            mid = curr;
        } else if (cnt%2==0){
            mid = mid.prev;
        }
    }

    int pop(){
        if(cnt == 0){
            System.out.printf("Stack is empty");
            return -1;
        }
        Node temp = head;
        int x = head.data;
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        cnt--;
        if(cnt%2 !=0){
            mid = mid.next;
        }
        return x;
    }

    int middle(){
        if(cnt == 0){
            System.out.printf("Stack is empty");
            return -1;
        }
        return mid.data;
    }
}
