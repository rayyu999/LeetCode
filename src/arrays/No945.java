package arrays;

import java.util.Arrays;

public class No945 {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int move = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] <= A[i - 1]) {
                move += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return move;
    }

}
