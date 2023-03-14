package org.parthvnp.Array;

import java.util.HashSet;

public class IsUnique {
    public static boolean IsUniqueWithHashMap(String string) {
        boolean flag = true;
        HashSet<Character> map = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            if (map.contains(string.charAt(i))) {
                flag = false;
                break;
            }
            map.add(string.charAt(i));
        }
        return flag;
    }

    public static boolean IsUniqueWithDoubleLoop(String string) {
        boolean flag = true;
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        // Empty string
        System.out.println(IsUniqueWithHashMap(""));
        System.out.println(IsUniqueWithDoubleLoop(""));
        // No repeating characters
        System.out.println(IsUniqueWithHashMap("ABCDEF"));
        System.out.println(IsUniqueWithDoubleLoop("ABCDEF"));
        // Characters repeating twice
        System.out.println(IsUniqueWithHashMap("AABCDEF"));
        System.out.println(IsUniqueWithDoubleLoop("AABCDEF"));
        // Characters repeating multiple times
        System.out.println(IsUniqueWithHashMap("AAABCDEF"));
        System.out.println(IsUniqueWithHashMap("AAABCDEF"));
        // Multiple single repeating characters
        System.out.println(IsUniqueWithHashMap("AAABCDEF"));
        System.out.println(IsUniqueWithDoubleLoop("AAABCDEF"));
        // Multiple characters repeating multiple times
        System.out.println(IsUniqueWithHashMap("AAABBBCDEF"));
        System.out.println(IsUniqueWithDoubleLoop("AAABBBCDEF"));
        // Repeats at start and end
        System.out.println(IsUniqueWithHashMap("ABA"));
        System.out.println(IsUniqueWithDoubleLoop("ABA"));

    }
}
