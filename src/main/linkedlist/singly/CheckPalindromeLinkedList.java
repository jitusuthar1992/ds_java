package main.linkedlist.singly;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Stack;

/**
 * @author jitendra.kumar01
 * 12/12/19
 */
public class CheckPalindromeLinkedList {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new ListNode(10);
        list.head.next = new ListNode(11);
        list.head.next.next = new ListNode(11);
        list.head.next.next.next = new ListNode(10);

        System.out.println(sol1(list.head));
    }

    //using stack
    public static boolean sol1(ListNode node){

        ListNode temp = node , temp1 = node ;
        if(node == null || node.next == null)
            return true;

        Stack<Integer> listNodes = new Stack<>();

        while(temp != null){
            listNodes.push(temp.data);
            temp = temp.next;
        }


        while (temp1 != null){
            if(temp1.data != listNodes.pop()){
                return false;
            }
            temp1 = temp1.next;
        }

        return true;
    }
}
