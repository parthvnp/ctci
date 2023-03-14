package org.parthvnp.String;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(!Character.isSpaceChar(s.charAt(i))) length++;
            else if(length > 0) return length;
        }
        return length;
    }

    public static void main(String[] args) {
        var l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("mad    lola "));
    }
}
