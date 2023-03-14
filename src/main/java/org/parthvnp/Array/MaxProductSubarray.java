package org.parthvnp.Array;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int ans = nums[0], currMaxProd, currMinProd, prevMaxProd = nums[0], prevMinProd = nums[0];
        for(int i = 1; i < nums.length; i++){
            currMaxProd  = Math.max(Math.max(prevMinProd * nums[i], prevMaxProd * nums[i]), nums[i]);
            currMinProd = Math.min(Math.max(prevMinProd * nums[i], prevMaxProd * nums[i]), nums[i]);
            ans = Math.max(ans, currMaxProd);
            prevMaxProd = currMaxProd;
            prevMinProd = currMinProd;
        }
        return ans;
    }

    public static void main(String[] args) {
        var m = new MaxProductSubarray();
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(m.maxProduct(nums));
    }
}
