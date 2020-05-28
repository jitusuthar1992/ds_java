package main.linkedlist.singly;

import java.util.HashMap;
import java.util.Map;

public class ReverseList {
    public  static ListNode reverse(ListNode head){
        ListNode prev = null,next =null, current = head;
        while(null != current){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current= next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("test1","test1");
        map.put("test1","test2");
        System.out.println(map.get("test1"));
        System.out.println(map.get("test1"));


    }

    public static ListNode reverseRecursively(ListNode node){
        if(null == node || null == node.next)
            return node;

        ListNode temp = reverseRecursively(node.next);
        node.next.next = node;
        node.next = null;
        return temp;

    }
    /*public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new ListNode(50);
        list.head.setNext(new ListNode(20));
        list.head.getNext().setNext(new ListNode(15));
        list.head.getNext().getNext().setNext(new ListNode(4));
        list.head.getNext().getNext().getNext().setNext(new ListNode(10));



        System.out.println("Linked List after reverse : ");
        list.printList(ReverseList.reverse(list.head));
    }*/

}
