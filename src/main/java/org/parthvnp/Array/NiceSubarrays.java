package org.parthvnp.Array;

public class NiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int answer = 0;
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] % 2 != 0) {
                count++;
                if (count == k) {
                    count -= 1;
                    answer += 1;
                }
            }
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        var s = new NiceSubarrays();
        var r = s.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2);
        System.out.println(r);
    }
}
