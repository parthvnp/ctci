package org.parthvnp.Array;

public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int pivot = findPivot(nums);
        if(target >= nums[0]) {
            return binarySearch(nums, 0, pivot == 0 ? nums.length - 1 : pivot - 1, target);
        }else{
            return binarySearch(nums, pivot, nums.length - 1, target);
        }
    }

    private int findPivot(int[] nums){
        int low = 0, high = nums.length - 1;
        if(nums[low] < nums[high]){return 0;}
        if(nums.length == 1){
            return 0;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if (mid - 1 >= 0 && nums[mid-1] > nums[mid]){
                return mid;
            }else if(nums[mid] >= nums[0]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
       return -1;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
       return -1;
    }

    public static void main(String[] args) {
        var search = new SearchRotatedArray();
        System.out.println(search.search(new int[]{1,3}, 1));
    }
}
