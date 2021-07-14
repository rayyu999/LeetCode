package test;


import arrays.JZOffer61;
import binsearch.No1818;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] a = new int[]{1,10,4,4,2,7};
        int[] b = new int[]{9,3,5,1,7,4};

        No1818 no1818 = new No1818();

        int c = no1818.minAbsoluteSumDiff(a, b);

        System.out.println(c);

    }

}
