package org.parthvnp.LinkedList;

public class LinkedList<T> {
    public Node<T> head;
    int size;

    public void addFront(T value){
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addRear(T value){
        if(size == 0){
           head = new Node<>(value);
        }else{
            var temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node<>(value);
        }
        size++;
    }

    public void addAllFront(T[] values){
        for (T value : values) {
            this.addFront(value);
        }
    }
    public void display() {
        var temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        s.addRear("A");
        s.addRear("B");
        s.addRear("C");
        s.addFront("D");
        s.display();
    }
}
