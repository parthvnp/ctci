package org.parthvnp.LinkedList;

public class MaxTwinSum {
  public int pairSum(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    // Get middle of the linked list.
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // Reverse second half of the linked list.
    ListNode nextNode, prev = null;
    while (slow != null) {
      nextNode = slow.next;
      slow.next = prev;
      prev = slow;
      slow = nextNode;
    }

    ListNode start = head;
    int maximumSum = 0;
    while (prev != null) {
      maximumSum = Math.max(maximumSum, start.val + prev.val);
      prev = prev.next;
      start = start.next;
    }

    return maximumSum;
  }

  public static void main(String[] args) {
    var s = new MaxTwinSum();
    var e1 = s.pairSum(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))));
    System.out.println(e1 == 9);
  }
}
