package org.parthvnp.LinkedList;

public class SwappingNodes {
    public ListNode swapNodes(ListNode head, int k) {
        // find the number of nodes
        var temp = head;
        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int back = size - k + 1;
        ListNode frontNode = null;
        ListNode backNode = null;
        temp = head;
        int i = 1;
        while(temp != null){
            if(i == k){
                frontNode = temp;
            }
            if(i == back){
                backNode = temp;
            }
            temp = temp.next;
            i++;
        }

        var tempVal = frontNode.val;
        frontNode.val = backNode.val;
        backNode.val = tempVal;
        return head;
    }

    public static void main(String[] args) {
        var s = new SwappingNodes();
        var e1 = s.swapNodes(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }

}
