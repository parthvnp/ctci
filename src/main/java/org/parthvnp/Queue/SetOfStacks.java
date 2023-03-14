package org.parthvnp.Queue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {
    ArrayList<Stack<Integer>> s = new ArrayList<Stack<Integer>>();
    private final int threshold;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    public void push(int value) {
        if (s.size() == 0) {
            s.add(new Stack<>());
        }
        var lastStack = s.get(s.size() - 1);
        if (lastStack.size() == threshold) {
            var newStack = new Stack<Integer>();
            newStack.add(value);
            s.add(newStack);
        } else {
            lastStack.add(value);
        }
    }

    public int pop() {
        if (s.size() == 0) {
            throw new EmptyStackException();
        }
        var last = s.get(s.size() - 1);
        if (last == null) {
            throw new EmptyStackException();
        }
        int v = last.pop();
        if (last.size() == 0) {
            s.remove(s.size() - 1);
        }
        return v;

    }

    public int popAt(int index) {
        if (index < 0 || index > s.size()) {
            throw new IllegalArgumentException("Argument must be between 0 and " + s.size());
        }
        var stack = s.get(index);
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return s.get(index).pop();
    }

    public static void main(String[] args) {
        SetOfStacks s = new SetOfStacks(10);
        for (int i = 0; i < 100; i++) {
            s.push(i);
        }
    }


}
