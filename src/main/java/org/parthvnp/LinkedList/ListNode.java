package org.parthvnp.LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void display(ListNode node){
        var temp = node;
        while(temp != null){
            System.out.print(temp.val +  " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(ListNode head, int ...values){
        for (int value : values) {
            head.next = new ListNode(value);
            head = head.next;
        }
    }
}
