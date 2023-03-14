package org.parthvnp.Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        int n = nums.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            res[i] = nums[n + i - k];
        }
        for (int i = 0; i < n - k; i++) {
            res[i + k] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public void rotatedUsingQueue(int[] nums, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            queue.add(nums[n - k + i]);
        }
        for(int i = 0; i < n - k; i++){
            queue.add(nums[i]);
        }
        for(int i = 0; i < n; i++){
            nums[i] = queue.remove();
        }
        System.out.println(Arrays.toString(nums));
    }

    public void rotatedInPlace(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        var rotateArray = new RotateArray();
        rotateArray.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotateArray.rotatedUsingQueue(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotateArray.rotatedInPlace(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
