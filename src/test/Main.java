package test;


import arrays.JZOffer61;
import dbfs.No1239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] a = new String[]{"cha","r","act","ers"};
        List<String> arr = Arrays.asList(a);

        No1239 no1239 = new No1239();

        int res = no1239.maxLength(arr);

        System.out.println(res);

    }

}
