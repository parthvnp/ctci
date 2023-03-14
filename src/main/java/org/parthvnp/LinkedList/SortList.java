package org.parthvnp.LinkedList;

public class SortList {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public ListNode sortList(ListNode head){
          if(head == null || head.next == null){
              return head;
          }
          ListNode mid = getMid(head);
          ListNode left = sortList(head);
          ListNode right = sortList(mid);
          return merge(left, right);
      }

      public ListNode getMid(ListNode node){
          ListNode midPrev = null;
          while(node != null && node.next != null){
             midPrev = (midPrev == null) ? node : midPrev.next;
             node = node.next.next;
          }
          ListNode mid = midPrev.next;
          midPrev.next = null;
          return mid;
      }

      public ListNode merge(ListNode list1, ListNode list2){
          ListNode dummy = new ListNode(-1);
          ListNode head = dummy;
          while(list1 != null && list2 != null){
              if(list1.val < list2.val){
                  dummy.next = new ListNode(list1.val);
                  dummy = dummy.next;
                  list1 = list2.next;
              }else{
                 dummy.next = new ListNode(list2.val);
                 dummy = dummy.next;
                 list2 = list2.next;
              }
          }
          dummy.next = list1 == null ? list2 : list1;
          return head.next;
      }

}
