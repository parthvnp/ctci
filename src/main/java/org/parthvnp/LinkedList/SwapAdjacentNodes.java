package org.parthvnp.LinkedList;

public class SwapAdjacentNodes {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;
        return second;
    }


    public ListNode swapPairsIterative(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode prev = sentinel;
        while(head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = first.next;
        }
        return sentinel.next;
    }
    public static void main(String[] args) {
        var s = new SwapAdjacentNodes();
        var e1 = s.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        var e2 = s.swapPairsIterative(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        e1.display(e1);
        e2.display(e2);
    }
}
