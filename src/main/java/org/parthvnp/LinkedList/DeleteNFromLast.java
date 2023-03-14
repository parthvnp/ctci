package org.parthvnp.LinkedList;

class DeleteNFromLast {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        var curr = head;
        for (int i = 0; i < n && curr != null; i++) {
            curr = curr.next;
            if (curr == null && n - 1 > i) {
                return null;
            }
        }
        var second = head;
        ListNode prev = null;
        while (curr != null) {
            curr = curr.next;
            prev = second;
            second = second.next;
        }
        if (prev != null) {
            prev.next = second.next;
        } else {
            assert head != null;
            head = head.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        var x = removeNthFromEnd(first, 3);
        var temp = x;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;

        }

    }
}