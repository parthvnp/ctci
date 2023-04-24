package org.parthvnp.Heap;

import java.util.*;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        var heap = new PriorityQueue<Integer>(stones.length, Comparator.comparingInt(a -> -a));
        for (var stone : stones) heap.add(stone);
        while (heap.size() > 1) {
            Integer x = heap.poll(), y = heap.poll();
            if (!x.equals(y)) heap.add(x - y);
        }
        return heap.size() == 1 ? heap.poll() : 0;
    }

    public static void main(String[] args) {
        var s = new LastStoneWeight();
        var e1 = s.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(e1 == 1);
        var e2 = s.lastStoneWeight(new int[]{2, 2});
        System.out.println(e2 == 0);
        var e3 = s.lastStoneWeight(new int[]{1, 3});
        System.out.println(e3 == 2);

    }
}
