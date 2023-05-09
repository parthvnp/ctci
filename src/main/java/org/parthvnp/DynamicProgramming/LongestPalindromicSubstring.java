package org.parthvnp.DynamicProgramming;

import java.util.Objects;

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int n = s.length(), startIndex = 0, max = 1;
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) dp[i][i] = true;
    for (int end = 0; end < n; end++) {
      for (int start = end - 1; start > -1; start--) {
        if (s.charAt(start) == s.charAt(end)) {
          if (end - start == 1 || dp[start + 1][end - 1]) {
            dp[start][end] = true;
            int palindromeLen = end - start + 1;
            if (palindromeLen > max) {
              max = palindromeLen;
              startIndex = start;
            }
          }
        }
      }
    }
    return s.substring(startIndex, startIndex + max);
  }

  public String longestPalindromeFromAroundCentre(String s) {
    int longestPalindromeLeft = 0, longestPalindromeRight = 0;
    for (int center = 0; center < s.length(); center++) {
      int left = center, right = center;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if (longestPalindromeRight - longestPalindromeLeft + 1 < right - left + 1) {
          longestPalindromeRight = right;
          longestPalindromeLeft = left;
        }
        left--;
        right++;
      }
      left = center;
      right = center + 1;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if (longestPalindromeRight - longestPalindromeLeft + 1 < right - left + 1) {
          longestPalindromeRight = right;
          longestPalindromeLeft = left;
        }
        left--;
        right++;
      }
    }
    return s.substring(longestPalindromeLeft, longestPalindromeRight + 1);
  }

  public static void main(String[] args) {
    var s = new LongestPalindromicSubstring();
    var e1 = s.longestPalindrome("babad");
    var e2 = s.longestPalindromeFromAroundCentre("babad");
    System.out.println(Objects.equals(e1, "bab") || Objects.equals(e1, "aba"));
    System.out.println(Objects.equals(e2, "bab") || Objects.equals(e2, "aba"));
  }
}
