package org.parthvnp.LinkedList;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode previous = null, current = slow.next;
        while (current != null) {
            var temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        // end the cycle
        slow.next = null;

        ListNode head1 = head, head2 = previous;
        while (head2 != null) {
            var temp = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = temp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(head, 2,3,4,5,6);
        var s = new ReorderList();
        s.reorderList(head);
        head.display(head);

    }
}
