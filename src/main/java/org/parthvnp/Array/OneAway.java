package org.parthvnp.Array;

import java.util.Arrays;
import java.util.HashMap;

public class OneAway {

    public static boolean isOneAway(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        Arrays.stream(s1.split("")).forEach(c -> map1.compute(c, (k, v) -> v == null ? 1 : ++v));
        Arrays.stream(s2.split("")).forEach(c -> map2.compute(c, (k, v) -> v == null ? 1 : ++v));
        return map1.entrySet().stream().filter(c -> Math.abs(map1.getOrDefault(c.getKey(), 0) - map2.getOrDefault(c.getKey(), 0)) == 1).count() == 1;
    }

    public static void main(String[] args) {
        // strings are the same
        System.out.println(isOneAway("A", "A") + " true");
        // string differ more than one character in length
        System.out.println(isOneAway("ABC", "A") + " false");
        // strings become equal if deleted one character
        System.out.println(isOneAway("ABC", "AB") + " true");
        // string with repeating characters with same condition as above
        System.out.println(isOneAway("AAAA", "AAA") + " true");
        // string become equal if one character inserted
        System.out.println(isOneAway("ABCD", "ABC") + " true");
        System.out.println(isOneAway("ABBB", "ABB") + " true");
        System.out.println(isOneAway("Parth", "Path") + " true");
        // strings are the same length but different content
        System.out.println(isOneAway("ABBBB", "ABB") + " false");
        // examples from book
        System.out.println(isOneAway("pale", "ple") + " true");
        System.out.println(isOneAway("pales", "pale") + " true");
        System.out.println(isOneAway("pale", "bale") + " true");
        System.out.println(isOneAway("pale", "bake") + " false");

    }
}
