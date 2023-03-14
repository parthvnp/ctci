package org.parthvnp.LinkedList;

public class DeleteMiddleNode {
    public static void DeleteMiddle(Node<Integer> node) {
        Node<Integer> current = node;
        while (current.next.next != null) {
            current.value = current.next.value;
            current = current.next;
        }
        current.value = current.next.value;
        current.next = null;
    }

    public static Node<Integer> DeleteLast(Node<Integer> node){
        Node<Integer> curr = node;
        if(curr == null || curr.next == null){
            return null;
        }
        while(curr.next.next != null){
           curr = curr.next;
        }
        curr.next = null;
        return node;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        node.addAll(node, new Integer[]{2,3, 4, 5,6,7});
        node.display(node);
        var x = new Node<>(1);
        node.display(x);
        x = DeleteLast(null);
        node.display(x);
    }
}
