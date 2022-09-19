package main.linkedlist.singly;

public class FlattenList {

    class Node {
        Node next;
        Node bottom;
        int data;
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        return merge(root, flatten((root.next)));
    }

    private Node merge(Node head1, Node head2) {
        if (null == head1) return head2;
        if (null == head2) return head1;
        Node result = null;

        if (head1.data < head2.data) {
            result = head1;
            result.bottom = merge(head1.bottom, head2);
        } else {
            result = head2;
            result.bottom = merge(head1, head2.bottom);
        }
        result.next = null;
        return result;
    }
}
