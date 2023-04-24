package org.parthvnp.DFS;

public class RestoreArray {
    public int numberOfArrays(String s, int k) {
        Integer[] dp = new Integer[s.length()]; // dp[i] is number of ways to print valid arrays from string s start at i
        return dfs(s, k, 0, dp);
    }

    int dfs(String s, long k, int i, Integer[] dp) {
        if (i == s.length()) return 1; // base case -> Found a valid way
        if (s.charAt(i) == '0')
            return 0; // all numbers are in range [1, k] and there are no leading zeros -> So numbers starting with 0 mean invalid!
        if (dp[i] != null) return dp[i];
        int ans = 0;
        long num = 0;
        for (int j = i; j < s.length(); j++) {
            num = num * 10 + s.charAt(j) - '0'; // num is the value of the substring s[i..j]
            if (num > k) break; // num must be in range [1, k]
            ans += dfs(s, k, j + 1, dp);
            ans %= 1_000_000_007;
        }
        return dp[i] = ans;
    }

    public static void main(String[] args) {
        var s = new RestoreArray();
        var r1 = s.numberOfArrays("1000", 10000);
        System.out.println(r1 == 1);
        var r2 = s.numberOfArrays("1000", 10);
        System.out.println(r2 == 0);
        var r3 = s.numberOfArrays("1317", 2000);
        System.out.println(r3 == 8);
        var r4 = s.numberOfArrays("2020", 30);
        System.out.println(r4 == 1);
        var r5 = s.numberOfArrays("1234567890", 90);
        System.out.println(r5 == 34);
    }
}
