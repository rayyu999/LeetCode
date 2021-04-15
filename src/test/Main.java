package test;

import arrays.No54;

public class Main {

    public static void main(String[] args) {

        No54 no54 = new No54();

        int[][] matrix = new int[3][3];
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{4,5,6};
        int[] c = new int[]{7,8,9};
        matrix[0] = a;
        matrix[1] = b;
        matrix[2] = c;
        no54.spiralOrder(matrix);
    }

}
