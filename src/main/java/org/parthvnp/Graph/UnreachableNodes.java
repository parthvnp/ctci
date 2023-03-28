package org.parthvnp.Graph;

import org.parthvnp.DisjointSet.DisjointSet;

import java.util.Arrays;
import java.util.HashMap;

public class UnreachableNodes {
    public long countPairs(int n, int[][] edges) {

        DisjointSet d = new DisjointSet(n);
        for(int[] i : edges) d.union(i[0], i[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(d.find(i), map.getOrDefault(d.find(i), 0) + 1);
        var sumSquared = map.values().stream().mapToLong(integer -> integer).map(i -> i * i).toArray();
        long unreachable_pairs = (long) n * n;
        for(var i: sumSquared) unreachable_pairs -= i;
        return unreachable_pairs / 2;
    }

    public static void main(String[] args) {
        var s = new UnreachableNodes();
        var e1 = s.countPairs(12, new int[][]{}  );
        System.out.println(e1);
    }
}
