package binarysearch;

/**
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
 *
 * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
 *
 * Return the ans % 10000003
 */

public class PaintersPartitionProblem {
    public int paint(int A, int B, int[] C) {
        long i=0, j=0;

        for(int num : C) {
            j += num;
            i = Math.max(i, num);
        }

        long result = 0;

        while(i <= j) {
            long mid = (i+j)/2;

            if(check(C, mid, A)) {
                result = mid;
                j = mid-1;
            } else i = mid+1;
        }

        return (int)((result*((long)B))%10000003);
    }

    public boolean check(int[] C, long mid, long num) {
        int workers = 1;
        long task = 0;

        for(int i=0; i<C.length; i++) {
            long currentTask = C[i];
            if(task + currentTask <= mid) {
                task += currentTask;
            } else {
                workers++;
                task = currentTask;
            }
        }

        if(workers > num) return false;
        return true;
    }
}
