package org.parthvnp.LinkedList;

import java.util.HashSet;
import java.util.List;

public class Intersection {
    public static ListNode FindIntersection(ListNode headA, ListNode headB) {
        HashSet<ListNode> map = new HashSet<>();
        var tempA = headA;
        var tempB = headB;
        while (tempA != null || tempB != null) {
            if (tempA != null) {
                if (!map.add(tempA)) {
                    return tempA;
                }
                tempA = tempA.next;
            }
            if (tempB != null) {
                if (!map.add(tempB)) {
                    return tempB;
                }
                tempB = tempB.next;
            }
        }
        return null;
    }

    public static ListNode FindIntersection2(ListNode headA, ListNode headB){
        ListNode tempA = headA, tempB = headB;
        int n1 = 0, n2 = 0;
        while(tempA != null){
           tempA = tempA.next;
           n1++;
        }
        while(tempB != null){
            tempB = tempB.next;
            n2++;
        }
        int diff = Math.abs(n1 - n2);
        ListNode tempA2, tempB2;
        if(n1 > n2){
           tempA2 = headA;
           tempB2 = headB;
        }
        else{
           tempB2 = headA;
           tempA2 = headB;
        }
        int i = 0;
        while(i < diff && tempA2 != null){
            tempA2 = tempA2.next;
            i++;
        }
        while(tempA2 != null && tempB2 != null){
            if(tempA2 == tempB2){
                return tempA2;
            }
            tempA2 = tempA2.next;
            tempB2 = tempB2.next;
        }
        return null;
    }
    public static ListNode reverse(ListNode node){
        ListNode prev = null, current = node, following;
        while(current != null){
            following = current.next;
            current.next = prev;
            prev = current;
            current = following;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode zero = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        zero.next = third;
        zero.display(first);
        zero.display(zero);
        zero = reverse(zero);
        first = reverse(first);
        zero.display(zero);
        zero.display(first);
        System.out.println(FindIntersection(first, zero).val);
        System.out.println(FindIntersection(first, zero).val);
    }
}
