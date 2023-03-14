package org.parthvnp.String;

public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        // Do it in O(N), using O(1)
        // use two pointers
        int s_end = edit(s);
        int t_end = edit(t);
        if (s_end != t_end || s_end < 0) {
            return false;
        }
        int temp = s_end;
        while (temp >= 0) {
            if (s.charAt(temp) != t.charAt(temp)) {
                return false;
            }
            temp--;
        }
        return true;
    }

    public int edit(String s) {
        int i = s.length() - 1;
        int j = s.length() - 1;
        // abc#d#
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                if (i - 1 >= 0 && s.charAt(i - 1) == '#') {
                    i--;
                    j--;
                } else if (i - 1 >= 0 && s.charAt(i - 1) != '#') {
                    i -= 2;
                    j -= 2;

                }
            } else  {
                i--;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        var s = new BackspaceCompare();
        System.out.println(s.edit("ab##"));
        System.out.println(s.edit("c#d#"));
        System.out.println(s.backspaceCompare("a#c", "b"));
    }
}
