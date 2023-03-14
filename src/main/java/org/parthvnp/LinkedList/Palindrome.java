package org.parthvnp.LinkedList;

import java.util.HashMap;
import java.util.Objects;

public class Palindrome {
    public static boolean isPalindrome(Node<String> s) {
        Node<String> fast = s;
        Node<String> slow = s;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverseAroundNode(slow.next);
        slow = slow.next;
        Node<String> temp = s;
        while(slow != null){
            if(!temp.value.equals(slow.value)){
                return  false;
            }
            slow = slow.next;
            temp = temp.next;
        }
        return true;

    }

    public static void reverse(LinkedList<String> s) {
        Node<String> previous = null;
        Node<String> current = s.head;
        Node<String> following;
        while (current != null) {
            following = current.next;
            current.next = previous;
            previous = current;
            current = following;
        }
        s.head = previous;
    }

    public static Node<String> reverseAroundNode(Node<String> s) {
        Node<String> previous = null;
        Node<String> current = s;
        Node<String> following;
        while (current != null) {
            following = current.next;
            current.next = previous;
            previous = current;
            current = following;
        }
        return previous;
    }

    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        s.addAllFront(new String[]{"A", "A"});
        s.display();
        System.out.println(isPalindrome(s.head));
    }
}
