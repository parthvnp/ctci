package org.parthvnp.LinkedList;

import java.util.Random;

public class RandomNode {
    public ListNode head;
    public int size = Integer.MAX_VALUE;
    public Random random;

    public RandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        var r = random.nextInt(this.size);
        int counter = 0;
        var temp = this.head;
        while (temp != null && counter++ < r) {
            temp = temp.next;
        }
        if (temp == null) {
            size = counter;
            assert this.head != null;
            return this.head.val;
        }
        return temp.val;
    }

    public static void main(String[] args) {
        var s = new RandomNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());

    }
}
