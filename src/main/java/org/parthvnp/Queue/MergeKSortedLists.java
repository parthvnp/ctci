package org.parthvnp.Queue;

import org.parthvnp.LinkedList.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for(var l: lists) if(l != null) pq.add(l);
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = new ListNode(curr.val);
            dummy = dummy.next;
            if (curr.next != null) pq.add(curr.next);
        }
        return head.next;
    }

    public static void main(String[] args) {
        var l1 = new ListNode(1);
        var l2 = new ListNode(2);
        var l3 = new ListNode(3);
        l1.add(l1, 3,3,4,5,6);
        l2.add(l2, 8, 9, 10, 12);
        l3.add(l3, 11, 14, 18);
        var s = new MergeKSortedLists();
        var merged = s.mergeKLists(new ListNode[]{null});
        if(merged != null) merged.display(merged);
    }
}
