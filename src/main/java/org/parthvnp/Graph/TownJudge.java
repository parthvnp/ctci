package org.parthvnp.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        var map = new HashMap<Integer, Integer>();
        for(int[] i : trust) map.compute(i[1], (k,v) -> v == null ? 1 : ++v);
        for(var i: map.entrySet()) if(i.getValue() == n - 1 && map.getOrDefault(i.getKey(), 0) == 0) return i.getKey();
        return -1;
    }

    public static void main(String[] args) {
        var s = new TownJudge();
        var r = s.findJudge(2, new int[][] {new int[]{1,2}});
        System.out.println(r);
    }
}
