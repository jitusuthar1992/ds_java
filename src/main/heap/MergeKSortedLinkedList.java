package main.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    static class Node implements Comparable<Node> {
        int data;
        Node next ;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public int compareTo(Node o) {
            return this.data - o.data;
        }
    }

    public static Node mergeKLinkedList(List<Node> list, int k) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (int i = 0; i <k ; i++) {
           if(list.get(i) != null){
               minHeap.add(list.get(i));
           }
        }


        Node head = null;
        Node tail = null;


        while (minHeap.size() > 0){
            Node node = minHeap.poll();
            if(head == null){
                head = tail = node;
                if(head.next != null){
                    minHeap.add(head.next );
                }
            }else {
                tail.next = node;
                tail = node;
                if(tail.next != null){
                    minHeap.add(tail.next);
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node l1 = new Node(3);
        Node l2 = new Node(5);
        Node l3 = new Node(8);
        Node l4 = new Node(12);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        Node l5 = new Node(1);
        Node l6 = new Node(4);
        Node l7 = new Node(8);
        Node l8 = new Node(12);

        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        Node l9 = new Node(4);
        Node l10 = new Node(8);
        Node l11 = new Node(13);
        Node l12 = new Node(15);

        l9.next = l10;
        l10.next = l11;
        l11.next = l12;

        List<Node> list = new ArrayList<>();
        list.add(l1);
        list.add(l5);
        list.add(l9);


        Node head =  MergeKSortedLinkedList.mergeKLinkedList(list,  3);

        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }

    }
}
