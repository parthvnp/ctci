package org.parthvnp.LinkedList;

public class RemoveDuplicates {
    public static Node<Integer> RemoveDuplicate(Node<Integer> node, int value) {
        while (node != null && node.value == value) {
            node = node.next;
        }
        Node<Integer> prev = null;
        Node<Integer> current = node;
        while(current != null){
            if(current.value == value){prev.next = current.next;}
            prev = current;
            current = current.next;
        }
        return node;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        node.addAll(node, new Integer[]{1,2, 1, 3, 1, 4, 1, 5,1, 6, 1});
        node.display(node);
        node.display(RemoveDuplicate(node, 1));

    }
}
