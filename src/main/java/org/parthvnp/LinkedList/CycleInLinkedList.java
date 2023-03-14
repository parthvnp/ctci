package org.parthvnp.LinkedList;

public class CycleInLinkedList {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head, temp = head;
        if(head.next == null){return null;}
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                while(temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth  = new ListNode(-4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        System.out.println(detectCycle(first).val);
    }
}
