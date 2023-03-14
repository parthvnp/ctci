package org.parthvnp.String;

import java.util.*;

public class LongestStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        var map = new HashMap<Character, Integer>();
        for (int low = 0, high = 0; high < s.length(); high++) {
            if (map.getOrDefault(s.charAt(high), 0) != 0) {
                while (map.getOrDefault(s.charAt(high), 0) != 0) {
                    map.remove(s.charAt(low));
                    low += 1;
                }
            }
            map.put(s.charAt(high), 1);
            res = Math.max(res, high - low + 1);

        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s){
        Integer[] chars = new Integer[128];
        int res = 0;
        for(int low = 0, high = 0; high < s.length(); high++){
            // store the index of the character in the array
            var index = chars[s.charAt(high)];
            // a character has already been seen, so reposition the low to the last index when the character was seen
            if(index != null && index >= low && index < high ) low = index + 1;
            chars[s.charAt(high)] = high;
            res = Math.max(res, high - low + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new LongestStringWithoutRepeatingCharacters();
        var r = s.lengthOfLongestSubstring2("abba");
        System.out.println(r);
    }
}
