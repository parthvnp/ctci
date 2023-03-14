package org.parthvnp.LinkedList;

public class Partition {
    public static Node<Integer> PartitionList(Node<Integer> list, int value) {
        Node<Integer> lessHead = null;
        Node<Integer> lessTail = null;
        Node<Integer> moreHead = null;
        Node<Integer> moreTail = null;
        Node<Integer> temp = list;
        while (temp != null) {
            if (temp.value < value) {
                if (lessHead == null) {
                    lessHead = new Node<>(temp.value);
                    lessTail = lessHead;
                } else {
                    lessTail.next = new Node<>(temp.value);
                    lessTail = lessTail.next;
                }
            } else {
                if (moreHead == null) {
                    moreHead = new Node<>(temp.value);
                    moreTail = moreHead;
                } else {
                    moreTail.next = new Node<>(temp.value);
                    moreTail = moreTail.next;
                }
            }
            temp = temp.next;
        }
        if (lessTail != null) {
            lessTail.next = moreHead;
        } else {
            return moreHead;
        }
        return lessHead;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        node.addAll(node, new Integer[]{});
        node.display(node);
        var x = PartitionList(node, 0);
        node.display(x);
    }

}
