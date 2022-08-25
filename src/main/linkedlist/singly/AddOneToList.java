package main.linkedlist.singly;

public class AddOneToList {
    private static ListNode addOne(ListNode head){
        if(head == null)
            return null;
        head = ReverseList.reverse(head);
        ListNode curr = head;

        while(curr != null){
            if(curr.next == null && curr.data ==0){
                curr.data = 0;
                ListNode temp = new ListNode(1);
                temp.next =head;
                head = temp;
                curr = curr.next;
            } else if (curr.data ==9) {
                curr.data = 0;
                curr = curr.next;
            }else {
                curr.data += 1;
                curr = curr.next;
                break;
            }
        }
        head = ReverseList.reverse(head);
        return head;
    }
}
