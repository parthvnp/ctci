package org.parthvnp.Queue;

import java.util.Stack;

public class QueueWithTwoStacks {
    Stack<Integer> inputBuf;
    Stack<Integer> out;
    public QueueWithTwoStacks() {
        inputBuf = new Stack<Integer>();
        out = new Stack<        >();
    }

    public void push(int x) {
        inputBuf.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public void rebalance(){
        if(out.isEmpty()){
            while(!inputBuf.isEmpty()){
                out.push(inputBuf.pop());
            }
        }
    }

    public int peek() {
        rebalance();
        return out.peek()   ;
    }

    public boolean empty() {
        return inputBuf.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        var q = new QueueWithTwoStacks();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.inputBuf);
        System.out.println(q.out);
        q.pop();
        System.out.println(q.inputBuf);
        System.out.println(q.out);
        q.pop();
        q.pop();
        System.out.println(q.empty());
    }
}
