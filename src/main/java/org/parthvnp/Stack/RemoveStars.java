package org.parthvnp.Stack;
import java.util.*;

public class RemoveStars {
    public String removeStars(String s) {
        var stack = new Stack<Character>();
        for (var c: s.toCharArray()){
            if(c != '*') stack.push(c);
            else{
                if (!stack.isEmpty()) stack.pop();
            }
        }
        return stack.stream().map(String::valueOf).reduce("", String::concat);
    }

    public static void main(String[] args) {
        var s = new RemoveStars();
        var r = s.removeStars("a*b**c");
        System.out.println(r);
        System.out.println(r.equals("c"));
    }
}
