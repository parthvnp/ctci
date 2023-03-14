package org.parthvnp.Queue;

import java.util.Stack;

public class StackMax extends Stack<Integer> {
    Stack<Integer> s2 = new Stack<>();
    public Integer max(){
       if(s2.isEmpty()){
           return Integer.MIN_VALUE;
       }else{
           return s2.peek();
       }
    }

    public void push(int value){
        if(value > max()){
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if(value == max()){
            s2.pop();
        }
        return value;
    }

    public static void main(String[] args) {
        StackMax s = new StackMax();
        s.push(10);
        s.push(11);
        s.push(12);
        s.push(13);
        s.push(14);
        System.out.println(s.max());
        s.pop();
        System.out.println(s.max());
        s.pop();
        System.out.println(s.max());
        s.pop();
        System.out.println(s.max());
        s.pop();
        System.out.println(s.max());

    }
}
