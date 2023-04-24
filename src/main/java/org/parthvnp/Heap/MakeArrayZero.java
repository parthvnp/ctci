package org.parthvnp.Heap;
import java.util.*;

public class MakeArrayZero {
    public int minimumOperations(int[] nums) {
        int count = 0;
        var heap = new PriorityQueue<Integer>();
        for(int i: nums){
            if(i != 0) heap.add(i);
        }
        while (!heap.isEmpty()){
            int min = heap.remove();
            ArrayList<Integer> list = new ArrayList<>();
            while(!heap.isEmpty()){
                int k = heap.remove();
                if(k - min > 0) list.add(k-min);
            }
            count += 1;
            heap.addAll(list);
        }
        return count;
    }

    public int minimumOperations2(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i: nums){
            if(i != 0) s.add(i);
        }
        return s.size();
    }

    public static void main(String[] args) {
        var s = new MakeArrayZero();
        var e1 = s.minimumOperations2(new int[]{1,5,0,3,5});
        System.out.println(e1 == 3);
        var e2 = s.minimumOperations2(new int[]{0});
        System.out.println(e2 == 0);

    }
}
