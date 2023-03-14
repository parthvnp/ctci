package org.parthvnp.String;

public class KMP {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int matchStartIdx = -1;
        if(haystack.equals(needle)) return 0;
        if(haystack.length() < needle.length()) return -1;
        while (i < haystack.length()) {
            int j = 0;
            while (j < needle.length() && i < haystack.length() && haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            }
            if (j == needle.length()) {
                matchStartIdx = i - j;
                break;
            } else {
                i = (i - j) + 1;
            }
        }
        return matchStartIdx;
    }

    public static void main(String[] args) {
        var s = new KMP();
        System.out.println(s.strStr("leetpythoncode", "python"));
    }
}
