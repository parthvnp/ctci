package org.parthvnp.Array;

import java.util.*;


public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] < target) {
                    count += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var s = new ThreeSumSmaller();
        var e2 = s.threeSumSmaller(new int[]{3, 1, 0, -2}, 4);
        System.out.println(e2 == 3);
        System.out.println(e2);

    }
}
