package org.parthvnp.Heap;
import java.util.*;

public class RelativeRank {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        var maxHeap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> -a[1]));
        for(int i = 0; i < score.length; i++) maxHeap.add(new int[]{i, score[i]});
        int j = 0;
        while(!maxHeap.isEmpty()) {
            var t = maxHeap.remove();
            if(j == 0) ans[t[0]] = "Gold Medal";
            else if(j == 1) ans[t[0]] = "Silver Medal";
            else if (j == 2) ans[t[0]] = "Bronze Medal";
            else ans[t[0]] = String.valueOf(j+1);
            j += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        var s = new RelativeRank();
        var e1 = s.findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(e1));
        System.out.println(Arrays.equals(e1, new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}));
        var e2 = s.findRelativeRanks(new int[]{10, 3, 8, 9, 4});
        System.out.println(Arrays.toString(e2));
        System.out.println(Arrays.equals(e2, new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"}));
    }
}
