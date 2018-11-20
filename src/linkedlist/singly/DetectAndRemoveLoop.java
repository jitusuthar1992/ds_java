package linkedlist.singly;


import java.util.HashSet;

public class DetectAndRemoveLoop {

        public static boolean detectLoopAndRemovesol1(ListNode node){
            ListNode slow= node,fast=node;
        while(null != slow && null != fast && null != fast.getNext()){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                removeLoop(slow,node);
            }
        }
        return  false;
    }

    public static void removeLoop(ListNode loop,ListNode curr){

            ListNode ptr1 = curr, ptr2=null;
            while(true){
                ptr2  = loop;
                while(ptr2.getNext() != loop && ptr2.getNext() != ptr1){
                    ptr2 = ptr2.getNext();
                }
                if(ptr1 == ptr2.getNext()){
                    break;
                }

                ptr1 = ptr1.getNext();
            }
            ptr2.setNext(null);
    }


    public static void detectLoopAndRemovesol2(ListNode node){
       ListNode temp = node,prev = null;
       boolean loopFound =false;

        HashSet<ListNode> set = new HashSet<>();
        while(null != temp){
            if(set.contains(temp)){
                loopFound= true;
                break;
            }

            set.add(temp);
            prev = temp;
            temp = temp.getNext();
        }
        if(true == loopFound)
            prev.setNext(null);
    }
        public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
            list.head = new ListNode(50);
            list.head.setNext(new ListNode(20));
            list.head.getNext().setNext(new ListNode(15));
            list.head.getNext().getNext().setNext(new ListNode(4));
            list.head.getNext().getNext().getNext().setNext(new ListNode(10));
            list.head.getNext().getNext().getNext().getNext().setNext(list.head.getNext().getNext());


            DetectAndRemoveLoop.detectLoopAndRemovesol1(list.head);
            System.out.println("Linked List after removing loop : ");
            list.printList(list.head);
        }

    }
