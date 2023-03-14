package org.parthvnp.Array;

import java.util.Arrays;
import java.util.HashMap;

public class StringCompression {
    public static String compressString(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.stream(s.split("")).forEach(c -> map.compute(c, (k,v) -> v == null ? 1: ++v));
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append(key).append(value));
        if(sb.toString().length() > s.length()){return s;}
        return sb.toString();
    }

    public static void main(String[] args) {
        // String of size 1
        System.out.println(compressString("a") + " a");
        // String of size > 1
        // Strings with all unique characters
        System.out.println(compressString("abcdef") + " abcdef");
        // String with all repeating characters
        System.out.println(compressString("aabbcc") +  " a2b2c2");
        // String with some repeating character and some unique characters
        System.out.println(compressString("aaaaabbcdefcd") + " a5b2c2de2e1f1");
    }
}
