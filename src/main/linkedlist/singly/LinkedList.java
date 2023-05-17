package main.linkedlist.singly;

public class LinkedList {

    public static void insert(int element, int position, Node head) {
        Node prev = null, current = null;
        int k = 1;
        if (null == head)
            return;
        current = head;
        Node newNode = new Node(element, null);
        if (position == 1) {
            newNode.next = current;
            current = newNode;
        } else {
            while ((null != current) && (k < position)) {
                k++;
                prev = current;
                current = current.next;
            }
            prev.next = newNode;
            newNode.next = current;
        }

    }

    public static int count(Node head) {
        int count = 0;
        if (head == null)
            return count;
        Node current = head;
        while (null != current) {
            count++;
            current = current.next;
        }
        return count;

    }

    public static void display(Node head) {
        if (null == head) {
            System.out.println("empty list");
        }
        while (null != head) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static Object delete(int position, Node head) {

        Node prev = null, current = null;
        int element;
        int k = 1;
        if (null == head) {
            System.out.println("list is empty");
            return "empty";
        }
        current = head;
        if (position == 1) {
            element = head.data;
            head = head.next;
            return element;

        }
        while ((null != current) && (k < position)) {
            k++;
            prev = current;
            current = current.next;
        }
        if (null == current) {
            System.out.println("position doesn't exist");
            return "position doesn't exist";
        }
        element = current.data;
        prev.next = current.next;


        return element;

    }

    public static void deleteList(Node head) {
        display(head);
        Node aux, iterator;
        iterator = head;
        while (null != iterator) {
            aux = iterator.next;
            iterator = aux;

        }
        display(head);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n2);
        //System.out.print("length ="+count(n3));
        deleteList(n3);

    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
    }
}






