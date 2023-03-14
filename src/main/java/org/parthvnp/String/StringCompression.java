package org.parthvnp.String;

import java.util.Arrays;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length == 1) return chars.length;
        int i = 0, j = 1, size = 0, pos = 0;
        while (j < chars.length) {
            if (chars[i] == chars[j]) j++;
            else {
                int count = (int) Math.floor(Math.log10(j - i)) + 1;
                size += (j - i) > 1 ? 1 + count : 1;
                if (j - i > 1) {
                    pos += fillCharArray(chars[i], j - i, chars, pos);
                } else {
                    chars[pos++] = chars[i];
                }
                i = j;
                j = i + 1;
            }
        }
        if (j - i > 1) {
            int count = (int) Math.floor(Math.log10(j - i)) + 1;
            fillCharArray(chars[i], j - i, chars, pos);
        } else chars[pos++] = chars[i];
        size += (j - i) > 1 ? 1 + Math.floor(Math.log10(j - i)) + 1 : 1;
        System.out.println(Arrays.toString(chars));
        return size;
    }

    public int fillCharArray(char c, int count, char[] res, int startPos) {
        // dirty trick for converting int to char array
        String[] nums = String.valueOf(count).split("");
        res[startPos++] = c;
        for (String num : nums) res[startPos++] = num.charAt(0);
        return nums.length + 1;
    }

    public int compress2(Character[] chars){
        int startIdx = 0, size = 0;
        while(startIdx < chars.length){
            var currentChar = chars[startIdx];
            var similarCharLength = 1;
            while(startIdx + similarCharLength < chars.length && chars[startIdx + similarCharLength] == currentChar) similarCharLength++;
            chars[similarCharLength] = currentChar;
            if(similarCharLength > 1){

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        var s = new StringCompression();
        var r = s.compress(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'});
        System.out.println(r);
    }
}
