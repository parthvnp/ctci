package org.parthvnp.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;

    }

    public static void main(String[] args) {
        var cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(new int[]{1,2,3,1}));
    }
}
