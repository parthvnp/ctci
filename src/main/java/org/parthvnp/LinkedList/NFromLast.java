package org.parthvnp.LinkedList;

public class NFromLast {
    private static Integer result;

    public static Integer FindNFromLast(Node<Integer> node, int k) {
        Node<Integer> current = node;
        for (int i = 0; current != null && i < k; i++) {
            current = current.next;
            if (current == null && k - 1 > i) {
                return null;
            }
        }
        Node<Integer> second = node;
        while (current != null) {
            current = current.next;
            second = second.next;
        }
        return second.value;
    }

    public static Integer NthFromLastRecursive(Node<Integer> node, int k) {
        if (node == null) return 0;
        int index = NthFromLastRecursive(node.next, k) + 1;
        if (index == k) result = node.value;
        return index;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        int k = 4;
        node = node.addAll(node, new Integer[]{2, 3, 4, 5, 6, 7, 8});
        var s = FindNFromLast(node, k);
        System.out.println(s);
        NthFromLastRecursive(node, k);
        System.out.println(result);
    }

}
