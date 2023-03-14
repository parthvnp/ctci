package org.parthvnp.Queue;

import java.util.Stack;

public class SortStack {
    private final Stack<Integer> stack = new Stack<>();

    public Integer pop() {
        return stack.pop();
    }

    public void push(Integer value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else if (value < stack.peek()) {
            stack.push(value);
        } else {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty() && stack.peek() <= value) {
                temp.push(stack.pop());
            }
            stack.push(value);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }

    public Integer peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortStack s = new SortStack();
        s.push(1);
        s.push(2);
        s.push(-1);
        s.push(-8);
        s.push(10);
        s.push(-100);
        s.push(10000);
        s.pop();
        s.push(-10000);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}
