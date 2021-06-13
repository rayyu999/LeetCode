package test;


import arrays.JZOffer61;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] a = new int[]{0, 0, 1, 2, 5};

        boolean b = JZOffer61.isStraight(a);

        System.out.println(Arrays.toString(a));
        System.out.println(b);

    }

}
