package main.queue;

import main.linkedlist.singly.ListNode;

public class QueueWithLinkedList {
    ListNode rear, front;

    public QueueWithLinkedList() {
        this.rear = null;
        this.front = null;
    }

    void enqueue(int data) {
        ListNode node = new ListNode(data);
        if (null == rear) {
            this.front = this.rear = node;
            return;
        }

        this.rear.setNext(node);
        this.rear = node;
    }

    ListNode dequeue() {
        if (null == front)
            return null;
        ListNode temp = this.front;
        this.front = this.front.getNext();

        if (null == front)
            this.rear = null;
        return temp;
    }

    public static void main(String[] args) {
        QueueWithLinkedList q = new QueueWithLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Dequeued item is " + q.dequeue().getData());
    }
}
