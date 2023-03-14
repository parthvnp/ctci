package org.parthvnp.Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class URLify {
    public static String ConvertSpaces(String s){
        return Arrays.stream(s.split("")).map(c -> c.equals(" ") ? "%20": c).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(ConvertSpaces("ABC DEF HIJK"));
    }
}
