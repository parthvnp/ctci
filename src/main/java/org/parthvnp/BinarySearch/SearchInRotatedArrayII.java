package org.parthvnp.BinarySearch;

public class SearchInRotatedArrayII {
  public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    if (nums[left] <= nums[right]) {
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return true;
        if (target > nums[mid]) left = mid + 1;
        else right = mid - 1;
      }
      return false;
    }
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) return true;
      // Case 1: a[left: mid] is sorted
      if (nums[left] < nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      // Case 2: a[mid: right] is sorted
      else if (nums[mid] < nums[right]) {
        if (nums[mid] < target && target <= nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      // Case 3: a[left: mid] and a[mid: right] are both unsorted
      else {
        System.out.println(left + " " + right);
        for (int i = left; i <= right; i++) {
          if (nums[i] == target) return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    var s = new SearchInRotatedArrayII();
    var e1 = s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 0);
    System.out.println(e1);
    var e2 = s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 3);
    System.out.println(e2);
    var e3 = s.search(new int[] {1, 1, 3, 1}, 3);
    System.out.println(e3);
    var e4 = s.search(new int[] {1, 3, 1, 1, 1}, 3);
    System.out.println(e4);
    var e5 = s.search(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}, 2);
    System.out.println(e5);
  }
}
