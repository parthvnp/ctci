package org.parthvnp.BinarySearch;

import java.util.Arrays;

public class FirstAndLastPos {
    public int[] searchRange(int[] nums, int target) {
        int leftAns = -1, rightAns = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                leftAns = leftAns == -1 ? mid : Math.min(leftAns, mid);
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                rightAns = rightAns == -1 ? mid : Math.max(rightAns, mid);
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{leftAns, rightAns};
    }

    public static void main(String[] args) {
        var s = new FirstAndLastPos();
        var e1 = s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(e1));
        var e2 = s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(e2));
        var e3 = s.searchRange(new int[]{1}, 1);
        System.out.println(Arrays.toString(e3));
        var e4 = s.searchRange(new int[]{1, 1, 1}, 1);
        System.out.println(Arrays.toString(e4));
    }
}
