package org.parthvnp.Math;

public class AddDigits {
    public int addDigits(int num) {
        return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
    }

    public static void main(String[] args) {
        var s = new AddDigits();
        var e1 = s.addDigits(38);
        System.out.println(e1 == 2);
        var e2 = s.addDigits(0);
        System.out.println(e2 == 0);
        var e3 = s.addDigits(9);
        System.out.println(e3 == 9);
    }
}
