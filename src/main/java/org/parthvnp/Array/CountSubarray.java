package org.parthvnp.Array;

public class CountSubarray {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int maxPosition = -1, minPosition = -1, leftBound = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) leftBound = i;
            if (nums[i] == maxK) maxPosition = i;
            if (nums[i] == minK) minPosition = i;
            res += Math.max(0, Math.min(maxPosition, minPosition) - leftBound);
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new CountSubarray();
        var r = s.countSubarrays(new int[]{1,1,1,1}, 1, 1);
        System.out.println(r);
    }
}
