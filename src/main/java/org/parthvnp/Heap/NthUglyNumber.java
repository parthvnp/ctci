package org.parthvnp.Heap;

import java.util.*;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        var pq = new PriorityQueue<Long>();
        var set = new HashSet<Long>();
        pq.add(1L);
        int[] primes = new int[]{2, 3, 5};
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = pq.remove();
            for (int prime : primes) {
                long next = ans * prime;
                if (!set.contains(next)) {
                    pq.add(next);
                    set.add(next);
                }
            }
        }
        return (int) ans;
    }

    public int nthUglyNumber2(int n){
        int[] nums = new int[1690];
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;
        for(int i = 1; i < n; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;
            if (ugly == nums[i2] * 2) ++i2;
            if (ugly == nums[i3] * 3) ++i3;
            if (ugly == nums[i5] * 5) ++i5;
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        var s = new NthUglyNumber();
        var e1 = s.nthUglyNumber2(10);
        System.out.println(e1 == 12);
        var e2 = s.nthUglyNumber2(1);
        System.out.println(e2 == 1);
        var e3 = s.nthUglyNumber2(11);
        System.out.println(e3 == 15);
        var e4 = s.nthUglyNumber2(1407);
        System.out.println(e4 == 536870912);

    }
}
