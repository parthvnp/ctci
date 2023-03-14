package org.parthvnp.Array;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low++] = nums[mid];
                nums[mid++] = temp;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    public void fourWayPartition(int[] A){
        int n0 = -1, n1 = -1, n2 = -1, n3 = -1;
        int n = A.length - 1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0)
            {
                A[++n3] = 3; A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n3] = 3; A[++n2] = 2; A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
               A[++n3] = 3; A[++n2] = 2;
            } else if (A[i] == 3) {
               A[++n3] = 3;
            }
        }
    }

    public static void main(String[] args) {
        var s = new SortColors();
        var a = new int[]{1, 2, 3, 1, 1, 1, 1, 0};
        s.fourWayPartition(a);
        System.out.println(Arrays.toString(a));
    }
}
