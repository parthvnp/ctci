package org.parthvnp.Array;

import java.util.Arrays;

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        // if there are no negative elements, iterate, square and return
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[i] * nums[i];
            }
        }
        // all negative numbers
        else if (nums[nums.length - 1] < 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                ans[nums.length - i - 1] = nums[i] * nums[i];

            }
        } else {
            // find the index of the first positive integer
            int firstPositiveNumIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    firstPositiveNumIndex = i;
                    break;
                }
            }
            // compare items to the left and right of this first positive index
            int lastIndexOfNegativeNumber = firstPositiveNumIndex - 1;
            int i = 0;
            while (lastIndexOfNegativeNumber >= 0 && firstPositiveNumIndex < nums.length) {
                if ((Math.abs(nums[lastIndexOfNegativeNumber]) < nums[firstPositiveNumIndex])) {
                    ans[i] = nums[lastIndexOfNegativeNumber] * nums[lastIndexOfNegativeNumber];
                    lastIndexOfNegativeNumber--;
                    i++;
                } else if (nums[firstPositiveNumIndex] <= Math.abs(nums[lastIndexOfNegativeNumber])) {
                    ans[i] = nums[firstPositiveNumIndex] * nums[firstPositiveNumIndex];
                    firstPositiveNumIndex++;
                    i++;
                }
            }

            while (lastIndexOfNegativeNumber >= 0) {
                ans[i] = nums[lastIndexOfNegativeNumber] * nums[lastIndexOfNegativeNumber];
                lastIndexOfNegativeNumber--;
                i++;
            }
            while (firstPositiveNumIndex < nums.length) {
                ans[i] = nums[firstPositiveNumIndex] * nums[firstPositiveNumIndex];
                firstPositiveNumIndex++;
                i++;
            }
        }

        return ans;
    }

    public int[] sortedSquareTwoPointer(int[] nums){
        int n = nums.length - 1;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        for(int p = n - 1; p >= 0; p--){
            if(Math.abs(nums[j]) > Math.abs(nums[i])){
               res[p] = nums[j] * nums[j];
               j--;
            }else{
                res[p] = nums[i] * nums[i];
                i++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        var squaresSortedArray = new SquaresSortedArray();
        System.out.println(Arrays.toString(squaresSortedArray.sortedSquareTwoPointer(new int[]{-5, -4, -3, -2, -1})));

    }
}
