package org.parthvnp.Queue;

import java.util.Stack;

public class StackMin extends Stack<Integer> {
    Stack<Integer> s2 = new Stack<>();

    public void push(int value) {
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        StackMin s = new StackMin();
        s.push(8);
        s.push(10);
        s.push(-10);
        System.out.println(s.s2);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        System.out.println(s);
    }
}
