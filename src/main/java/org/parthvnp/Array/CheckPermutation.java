package org.parthvnp.Array;

import java.util.HashMap;

public class CheckPermutation {
    public static boolean Check(String a, String b) {
        boolean flag = true;
        // A string is a permutation if they have the same length, and the same number of each of the characters.
        if (a.length() != b.length()) {
            return false;
        }
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        a.chars().mapToObj(c -> (char) c).forEach(c -> mapA.compute(c, (k, v) -> v == null ? 1 : ++v));
        b.chars().mapToObj(c -> (char) c).forEach(c -> mapB.compute(c, (k, v) -> v == null ? 1 : ++v));
        return mapA.entrySet().stream().map(k -> mapB.getOrDefault(k.getKey(), 0).equals(k.getValue())).filter(c -> c).toList().size() == mapB.size();
    }

    public static void main(String[] args) {
        // String with size 1
        System.out.println(Check("A", "A"));
        // String with size > 1
        // String with different sizes
        System.out.println(Check("AB", "A"));
        // String with same size but no permutations
        System.out.println(Check("John", "Sammy"));
        // String with same size and permutations
        System.out.println(Check("hannah", "hannha"));
        // String with all repeating characters
        System.out.println(Check("AAAA", "AAAA"));
    }
}
