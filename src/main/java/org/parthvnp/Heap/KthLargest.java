package org.parthvnp.Heap;

import java.util.*;

class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int num: nums) heap.offer(num);
        while (heap.size() > k) heap.poll();
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }

    public static void main(String[] args) {
        var s = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(s.add(3) == 4);
        System.out.println(s.add(5) == 5);
        System.out.println(s.add(10) == 5);
        System.out.println(s.add(9) == 8);
        System.out.println(s.add(4) == 8);
    }
}