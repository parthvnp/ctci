package org.parthvnp.Queue;

import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> enqueueStack = new Stack<>();
    private final Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(Integer value){
        enqueueStack.push(value);
    }

    public Integer dequeue(){
        if(enqueueStack.isEmpty()){
            return null;
        }
        while(!enqueueStack.isEmpty())     {
            dequeueStack.push(enqueueStack.pop());
        }
        int retVal = dequeueStack.pop();
        while(!dequeueStack.isEmpty()){
            enqueueStack.push(dequeueStack.pop());
        }
        return retVal;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println(myQueue.dequeue());
        myQueue.enqueue(4);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
