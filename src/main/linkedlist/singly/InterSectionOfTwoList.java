package main.linkedlist.singly;

public class InterSectionOfTwoList {

    private ListNode findIntersection(ListNode head1, ListNode head2) {
        ListNode head = null, current = null;
        ListNode ptr1 = head1, ptr2 = head2;

        while (null != ptr1 && null != ptr2) {
            if (ptr2.data == ptr1.data) {
                ListNode temp = new ListNode(ptr1.data);
                if(null == head){
                    head = temp;
                    current = temp;
                }else {
                    current.next = temp;
                    current = current.next;
                }
            }else {
                if(ptr1.data < ptr2.data){
                    ptr1 = ptr1.next;
                }else {
                    ptr2 = ptr2.next;
                }
            }
        }
        return  head;
    }
}
