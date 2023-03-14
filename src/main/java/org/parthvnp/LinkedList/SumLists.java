package org.parthvnp.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class SumLists {
    public static Node<Integer> reverseOrderSumList(Node<Integer> n1, Node<Integer> n2) {
        int carry = 0;
        Node<Integer> t1 = n1;
        Node<Integer> t2 = n2;
        Node<Integer> resultHead = null;
        Node<Integer> result = null;
        // assume same number of digits provided
        while (t1 != null || t2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (t1 != null) {
                v1 = t1.value;
            }
            if (t2 != null) {
                v2 = t2.value;
            }
            int r = (carry + v1 + v2) % 10;
            carry = (carry + v1 + v2) / 10;
            if (resultHead == null) {
                resultHead = new Node<>(r);
                result = resultHead;
            } else {
                result.next = new Node<>(r);
                result = result.next;
            }
            if (t1 != null) {
                t1 = t1.next;
            }
            if (t2 != null) {
                t2 = t2.next;
            }

        }
        if (carry > 0) {
            result.next = new Node<>(carry);
        }
        return resultHead;
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(9);
        Node<Integer> n2 = new Node<>(9);
        n1.addAll(n1, new Integer[]{9, 9, 9});
        n2.addAll(n2, new Integer[]{});
        n1.display(n1);
        n2.display(n2);
        var x = reverseOrderSumList(n1, n2);
        n1.display(x);
    }
}
