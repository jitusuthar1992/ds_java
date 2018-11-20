package linkedlist.singly;

public class SinglyLinkedList {

    public SinglyLinkedList() {
        length =0;
    }
    private int length;
    public  ListNode head;



    //Traversing and finding length of  list
    //time complexity O(n) and space complexity O(1)
    public int listLength(ListNode head){
        ListNode currentNode = head;
        while (null != currentNode){
            length++;
            currentNode = currentNode.getNext();
        }
        return  length;
    }

    public  synchronized ListNode getHead(){
        return  head;
    }

    //insert new node at the beginning
    public synchronized void insertAtBegin(ListNode node){
        node.setNext(head);
        head = node;
        length++;
    }

    public   void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }

        //insert new node at the end
    public synchronized  void insertAtEnd(ListNode node){
        if(null==head){
            node.setNext(null);
            head = node;
        }else{
            ListNode current = head,prev=null;
            while(null != current){
                prev = current;
                current = current.getNext();
            }
            prev.setNext(node);
            node.setNext(null);
            length++;

        }
    }

    //add a new node at given position
    public synchronized void insertAtPosition(int data , int position){
        //fix the position
        if(0 > position){
            position =0;
        }
        if(length < position){
            position = length;
        }
        //if the list is empty then make it to first node
        if(null == head){
            head =new ListNode(data);
        }
        //if adding at first
        if(0 == position){
            ListNode temp = new ListNode(data);
            temp.setNext(head);
            head = temp;
        }else{
            //find the correct postion
            ListNode temp = head;
            for (int i = 0; i <position ; i++) {
                temp = temp.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }

        length++;

    }

    //remove a node from beginning
    public synchronized  ListNode removeFromBegin(){
        ListNode temp = head;
        if(null != temp){
            head = head.getNext();
            temp.setNext(null);
        }
        return  temp;
    }

    //remove a node from end
    public synchronized  ListNode removeFromEnd(){

        if(null == head){
            return null;
        }
        ListNode current = head, prev = null, next = head.getNext();
        if(null ==head){
            head = null;
            return  current;
        }
        while( null != current){
            prev = current;
            current = current.getNext();
        }
        prev.setNext(null);
        return current;
    }

    //remove matched node
    public  synchronized  void removeMatched(ListNode node){
        if(null == head)
            return;
        if(node.equals(head)){
            head = head.getNext();
            return;
        }
        ListNode current = head,prev = null;
        while(null!= current){
            if(current.equals(node)){
                prev.setNext(current.getNext());
                return;
            }
        }

    }

    //remove at position

    public synchronized void remove(int position){
        if( 0 > position)
            position=0;
        if(length <= position )
            position = length-1;
        if(null == head){
            return;
        }
        if(0== position){
            head = head.getNext();
        }else{
            ListNode temp = head;
            for (int i = 0; i <position ; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length--;
    }

    public  synchronized void removeEveryThingFromList(){
        head = null;
        length=0;
    }


}

