package org.parthvnp.Stack;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        var comps = s.split("");
        var stack = new Stack<String>();
        var openingPairs = List.of("{", "(", "[");
        var closingPairs = List.of("}", ")", "]");
        for (int i = 0; i < comps.length; i++) {
            if (openingPairs.contains(comps[i])) {
                stack.push(comps[i]);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                var popped = stack.pop();
                if (!(closingPairs.get(openingPairs.indexOf(popped)).equals(comps[i]))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        var vp = new ValidParentheses();
        System.out.println(vp.isValid("(())"));
    }
}
