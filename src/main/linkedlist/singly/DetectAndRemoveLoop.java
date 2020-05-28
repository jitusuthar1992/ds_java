package main.linkedlist.singly;


import java.util.HashSet;
import java.util.Map;

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

            list.head = new ListNode(12);
            list.head.setNext(new ListNode(99));
            list.head.getNext().setNext(new ListNode(13));
            list.head.getNext().getNext().setNext(new ListNode(5));
            list.head.getNext().getNext().getNext().setNext(new ListNode(25));
            list.head.getNext().getNext().getNext().getNext().setNext(list.head);

           // System.out.println("Linked List before removing loop : ");
           // list.printList(list.head);

            DetectAndRemoveLoop.removeLoopSol(list.head);
            System.out.println("Linked List after removing loop : ");
           list.printList(list.head);

        }


        public static void removeLoopSol(ListNode head){
            ListNode slow ,fast;
            slow=fast=head;
            while(fast.next != null && fast.next.next!= null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow.data == fast.data){
                    break;
                }
            }

            if(fast == slow){
                if(fast == head){
                    while (slow.next != fast){
                        slow= slow.next;
                    }

                    slow.next = null;
                }else {
                    slow = head;
                    while (slow.next != fast.next){
                        slow = slow.next;
                    }
                    fast.next = null;
                }
            }



        }

    }
