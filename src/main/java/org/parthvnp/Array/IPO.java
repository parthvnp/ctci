package org.parthvnp.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // pick a project i. capital[i] <= w. No sorting allowed because profits and capital index should be left unchanged.
        // Bounds for choice of i:
        // Pick the project that returns the most capital, for the same amount of w. So try to maximize for profit and thereby capital.
        // Once the project has been selected, decrement k. Now to pick the next project, again look at the profit for each project whose capital is less than w and then pick the one that maximizes for the capital.
        // Some calculation will be repeated several times like checking the project with most capital, so it would be ideal to preprocess the array somehow.
        // maximization -> DP?
        // backtrack
        // Brute force
        int ans = 0;
        Set<Integer> s = new HashSet<>();
        while (k > 0) {
            int maxIdx = -1;
            int max = -1;
            for (int i = 0; i < profits.length; i++) {
                if (capital[i] <= w && profits[i] > max && !s.contains(i)) {
                    maxIdx = i;
                    max = profits[i];
                }
            }
            if(maxIdx == -1){
                return w;
            }
            w += profits[maxIdx];
            ans += w;
            s.add(maxIdx);
            k--;
        }
        return w;
    }




    public static void main(String[] args) {
        var s = new IPO();
//        Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
        // k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
        System.out.println(s.findMaximizedCapital(10, 0, new int[]{1,2,3}, new int[]{0,1,2}));

    }
}
