package org.parthvnp.Array;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new TwoSum();
        var r = s.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(r));
    }
}
