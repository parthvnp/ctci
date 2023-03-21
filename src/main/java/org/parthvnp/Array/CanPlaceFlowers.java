package org.parthvnp.Array;

public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0) {
        boolean emptyLeftSide = i == 0 || flowerbed[i - 1] == 0;
        boolean emptyRightSide = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
        if (emptyLeftSide && emptyRightSide) {
          flowerbed[i] = 1;
          count += 1;
          if (count == n) return true;
        }
      }
    }
    return count >= n;
  }

  public static void main(String[] args) {
    var s = new CanPlaceFlowers();
    var r = s.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2);
    System.out.println(r);
  }
}
