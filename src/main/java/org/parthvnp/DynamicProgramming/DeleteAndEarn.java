package org.parthvnp.DynamicProgramming;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums) values[num] += num;
        int[] dp = new int[n];
        dp[1] = values[1];
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-2] + values[i], dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        var s = new DeleteAndEarn();
        var e1 = s.deleteAndEarn(new int[]{3, 4, 2});
        System.out.println(e1 == 6);
        var e2 = s.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
        System.out.println(e2 == 9);
        var e3 = s.deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6});
        System.out.println(e3 == 18);
    }
}
