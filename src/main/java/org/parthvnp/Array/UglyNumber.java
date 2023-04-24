package org.parthvnp.Array;

public class UglyNumber {
  public boolean isUgly(int n) {
    if (n <= 0) return false;
    int[] x = new int[] {2, 3, 5};
    for (int i : x) n = kd(n, i);
    return n == 1;
  }

  public int kd(int dividend, int divisor) {
    while (dividend % divisor == 0) dividend = dividend / divisor;
    return dividend;
  }

  public static void main(String[] args) {
    var s = new UglyNumber();
    System.out.println(s.isUgly(6));
    System.out.println(s.isUgly(8));
    System.out.println(s.isUgly(14));
  }
}
