package main.linkedlist.singly;

public class DeleteMiddleNode {
    public static ListNode deleteMiddleNode(ListNode head) {
        if (null == head || null == head.next)
            return null;

        ListNode prev = null, slow = head, fast = head;

        while (null != fast && null != fast.next) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return slow;
    }
}
