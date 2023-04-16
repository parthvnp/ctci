package org.parthvnp.DP;

import java.util.*;

public class MaxValueOfKCoins {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] memo = new Integer[piles.size() + 1][k + 1];

        return dp(piles, memo, 0, k);
    }

    public int dp(List<List<Integer>> piles, Integer[][] memo, int i, int k) {
        if (k == 0 || i == piles.size()) return 0;
        if (memo[i][k] != null) return memo[i][k];

        int res = dp(piles, memo, i + 1, k);
        int cur = 0;

        for (int j = 0; j < Math.min(piles.get(i).size(), k); ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, cur + dp(piles, memo, i + 1, k - j - 1));
        }
        return memo[i][k] = res;
    }

    public static void main(String[] args) {
        var s = new MaxValueOfKCoins();
        var e1 = s.maxValueOfCoins(List.of(List.of(2, 4, 1), List.of(4, 3, 6), List.of(2, 0, 5), List.of(1, 3, 1)), 4);
        System.out.println(e1 == 15);
        var e2 = s.maxValueOfCoins(List.of(List.of(9, 8, 7), List.of(6, 5, 1), List.of(2, 3, 4)), 2);
        System.out.println(e2 == 17);
        var e3 = s.maxValueOfCoins(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)), 3);
        System.out.println(e3 == 24);
        var e4 = s.maxValueOfCoins(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)), 4);
        System.out.println(e4 == 28);
    }
}
