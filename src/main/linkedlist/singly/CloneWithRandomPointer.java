package main.linkedlist.singly;

public class CloneWithRandomPointer {

    static class Node {
        int data;
        Node next, random;

        Node(int x) {
            data = x;
            next = random = null;
        }
    }

    static Node clone(Node start) {
        Node curr = start, temp = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }

        curr = start;
        while (curr != null) {
            if (curr.next != null) {
                curr.next.random = curr.random != null ? curr.random.next : curr.random;

            }
            curr = (curr.next != null) ? curr.next.next : curr.next;
        }


        Node original = start, copy = start.next;

        // save the start of copied linked list
        temp = copy;
        while (original != null && copy != null) {
            original.next = (original.next != null) ?
                    original.next.next : original.next;

            copy.next = (copy.next != null) ? copy.next.next
                    : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        Node cloned_list = clone(start);
        print(cloned_list);

    }

    static void print(Node start) {
        Node ptr = start;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data +
                    ", Random = " + ptr.random.data);
            ptr = ptr.next;
        }
    }


}
