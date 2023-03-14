package org.parthvnp.Array;

public class RotatedArrayMin {
    public int findMin(int[] nums) {
        return findPivot(nums);
    }

    private int findPivot(int[] nums) {
        int low = 0, high = nums.length - 1;
        if(nums.length == 1){return 0;}
        if (nums[low] < nums[high]) {
            return low;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[mid] >= nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var rotatedMinArray = new RotatedArrayMin();
        System.out.println(rotatedMinArray.findPivot(new int[] {2, 4, 8, 1}));
    }
}
