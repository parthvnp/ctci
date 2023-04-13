package org.parthvnp.Stack;

import java.util.*;

public class ValidStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // simply check if any of the values in popped sequence appears before it could have been pushed.
        // if it does, then the sequence is invalid.
        var stack = new Stack<Integer>();
        int j = 0;
        for(int i: pushed){
            stack.push(i);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        var s = new ValidStackSequence();
        var e1 = s.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        System.out.println(e1);
        var e2 = s.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
        System.out.println(e2);
    }
}
