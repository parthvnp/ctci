package org.parthvnp.LinkedList;

import java.util.Arrays;

public class Node<T>{
    public T value;
    public Node<T> next;
    public Node(T value){
        this.value = value;
    }

    public Node(){

    }

    public Node<T> addAll(Node<T> node, T[] values){
       Node<T> temp = node;
       for(T value: values){
           temp.next = new Node<>(value);
           temp = temp.next;
       }
       return node;
    }



    public void display(Node<T> node){
        var temp = node;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
