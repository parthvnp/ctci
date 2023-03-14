package org.parthvnp.LinkedList;

import java.util.List;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = null;
        for (ListNode list : lists) {
            answer = merge(list, answer);
        }
        return answer;

    }

    public ListNode merge(ListNode head1, ListNode head2){
        var dummy = new ListNode(-1);
        var head = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                dummy.next = new ListNode(head1.val);
                dummy = dummy.next;
                head1 = head1.next;
            }else{
                dummy.next = new ListNode(head2.val);
                dummy = dummy.next;
                head2 = head2.next;
            }
        }
        dummy.next = head1 == null ? head2.next : head1.next;
        return head.next;
    }

    public static void main(String[] args) {
        var l1 = new ListNode(1);
        var l2 = new ListNode(2);
        var l3 = new ListNode(-1);
        l1.add(l1, 2,3,4,5,6);
        l2.add(l2, 4,8, 28, 90);
        l3.add(l3, 0, 1, 8, 100);
        var lists = new ListNode[]{l1, l2, l3};
        var s = new MergeKSortedList();
        var ans = s.mergeKLists(lists);
        ans.display(ans);

    }
}
