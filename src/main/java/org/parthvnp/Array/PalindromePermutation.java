package org.parthvnp.Array;

import java.util.Arrays;
import java.util.HashMap;

public class PalindromePermutation {

    public static boolean willPermutationFormPalindrome(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.stream(s.split("")).forEach(c -> map.compute(c, (k, v) -> v == null ? 1 : ++v));
        if(map.size() == 1){return true;}
        if (s.length() % 2 == 0) {
            return map.values().stream().reduce(0, (k, v) -> k + ((v % 2 == 0) ? 1 : 0)).equals(map.size());
        }
        return map.values().stream().filter(c -> c == 1).count() == 1 &&  map.values().stream().filter(c -> c % 2 == 0).count() == map.size() - 1;
    }

    public static void main(String[] args) {
        // no repeating characters
        System.out.println(willPermutationFormPalindrome("code") + " false");
        // repeating characters but uneven numbers
        System.out.println(willPermutationFormPalindrome("aabaaa") + " false");
        // repeating characters even numbers
        System.out.println(willPermutationFormPalindrome("aaaa") + " true");
        // repeating characters odd numbers
        System.out.println(willPermutationFormPalindrome("aaaaa") + " true");
        // repeating characters even number of time, but string is odd length
        System.out.println(willPermutationFormPalindrome("aab") + " true");
        // each character repeats the same number of times
        System.out.println(willPermutationFormPalindrome("aabb") + " true");
        // string of length 1
        System.out.println(willPermutationFormPalindrome("a") + " true");
        // string of odd length where one character repeats only once, but every other character repeats even number of times
        System.out.println(willPermutationFormPalindrome("aabaa") + " true");
        // string of odd and multiple characters repeats even number of times
        System.out.println(willPermutationFormPalindrome("tactcoa") + " true");
        // more than one character only exists once
        System.out.println(willPermutationFormPalindrome("abcdeabcdd"));
    }
}
