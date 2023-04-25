package org.parthvnp.Heap;

import java.util.*;

public class SmallestInfiniteSet {
    private final PriorityQueue<Integer> pq;
    private final HashSet<Integer> removedSet;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        removedSet = new HashSet<>();
        pq.add(1);
    }

    public int popSmallest() {
        int retVal = pq.remove();
        removedSet.add(retVal);
        if (pq.isEmpty()) pq.add(retVal + 1);
        return retVal;
    }

    public void addBack(int num) {
        if (removedSet.contains(num)) {
            pq.add(num);
            removedSet.remove(num);
        }
    }

    public static void main(String[] args) {
        var s = new SmallestInfiniteSet();
        var e1 = s.popSmallest();
        System.out.println(e1 == 1);
        var e2 = s.popSmallest();
        System.out.println(e2 == 2);
        var e3 = s.popSmallest();
        System.out.println(e3 == 3);
        var e4 = s.popSmallest();
        System.out.println(e4 == 4);
        var e5 = s.popSmallest();
        System.out.println(e5 == 5);
        s.addBack(3);
        var e6 = s.popSmallest();
        System.out.println(e6 == 3);
        s.addBack(1);
        var e7 = s.popSmallest();
        System.out.println(e7 == 1);
    }
}