package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        System.out.println(task6.hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));

        System.out.println(Arrays.deepToString(task6.collect("strengths", 3) ));

        System.out.println(task6.nicoCipher("mubashirhassan", "crazy"));

        System.out.println(Arrays.toString(task6.twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15, 3}, 45 )));

        System.out.println(Arrays.toString(task6.isExact(6)));

        System.out.println(task6.fractions("0.(6)"));

        System.out.println(task6.pilish_string("33314444"));

        System.out.println(task6.generateNonconsecutive(4));

        System.out.println(task6.isValid("abcdefghhgfedecba"));

        System.out.println(Arrays.deepToString(task6.sumsUp(new int[]{1, 2, 3, 4, 5})));
    }
}
