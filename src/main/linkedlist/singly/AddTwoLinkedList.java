package main.linkedlist.singly;

public class AddTwoLinkedList {
    static Node head1, head2;

    static Node addTwoList(Node first, Node second) {
        Node res = null, prev = null, temp = null;
        int sum = 0, carry = 0;

        while (null != first || null != second) {
            sum = carry + (null != first ? first.data : 0) + (null != second ? second.data : 0);

            carry = sum >= 10 ? 1 : 0;

            sum = sum % 10;

            temp = new Node(sum, null);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (null != first)
                first = first.next;
            if (null != second)
                second = second.next;

        }

        if (carry > 0) {
            temp.next = new Node(carry, null);
        }
        return res;

    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        AddTwoLinkedList list = new AddTwoLinkedList();

        // creating first list
        list.head1 = new Node(7, null);
        list.head1.next = new Node(5, null);
        list.head1.next.next = new Node(9, null);
        list.head1.next.next.next = new Node(4, null);
        list.head1.next.next.next.next = new Node(6, null);
        System.out.print("First List is ");
        list.printList(head1);

        // creating seconnd list
        list.head2 = new Node(8, null);
        list.head2.next = new Node(4, null);
        System.out.print("Second List is ");
        list.printList(head2);

        // add the two lists and see the result
        Node rs = AddTwoLinkedList.addTwoList(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }

}
