package org.parthvnp.Array;

public class StringRotation {
    public static boolean isSubString(String s1, String s2) {
        return true;
    }

    public static boolean isSubstringRotation(String s1, String s2) {
        var c = s1 + s1;
        return s1.length() == s2.length() && (c.contains(s2));
    }

    public static String rightRotate(String s1, int index) {
        assert index <= s1.length() - 1;
        return s1.substring(index) +
                s1.substring(0, index);
    }

    public static String leftRotate(String s1, int index) {
        return s1.substring(s1.length() - index) + s1.substring(0, s1.length() - index);
    }

    public static void main(String[] args) {
        String s = "happy";

        System.out.println(rightRotate(s, 4));
        System.out.println(leftRotate(s, 4));
    }
}
