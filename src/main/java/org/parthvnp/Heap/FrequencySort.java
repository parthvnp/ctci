package org.parthvnp.Heap;

import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        var heap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> -a[1]));
        var map = new HashMap<Character, Integer>();

        for (var c : s.toCharArray()) map.compute(c, (k, v) -> v == null ? 1 : ++v);
        for (var k : map.entrySet()) heap.add(new int[]{k.getKey(), k.getValue()});

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            var t = heap.remove();
            sb.append(String.valueOf((char) t[0]).repeat(t[1]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = new FrequencySort();
        var e1 = s.frequencySort("tree");
        System.out.println(e1.equals("eert") || e1.equals("eetr"));
        var e2 = s.frequencySort("cccaaa");
        System.out.println(e2.equals("cccaaa") || e2.equals("aaaccc"));
        var e3 = s.frequencySort("Aabb");
        System.out.println(e3.equals("bbAa") || e3.equals("bbaA"));
    }
}
