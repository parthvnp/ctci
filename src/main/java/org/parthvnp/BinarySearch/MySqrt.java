package org.parthvnp.BinarySearch;

public class MySqrt {
  public int mySqrt(int x) {
    long left = 0, right = x;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      if (mid * mid == x) return (int) mid;
      if (x > mid * mid) left = mid + 1;
      else right = mid - 1;
    }
    return (int) left - 1;
  }

  public static void main(String[] args) {
    var s = new MySqrt();
    var e1 = s.mySqrt(2147395599);
    System.out.println(e1);
  }
}
