package binarysearch;

/**
 * Given an array of integers A and an integer B, find and
 * return the maximum value K such that there is no subarray
 * in A of size K with the sum of elements greater than B.
 */

public class SpecialInteger {

    public int solve(int[] A, int B) {
        int max = 0;

        int i=1, j=A.length;

        while(i <= j) {
            int mid = (i+j)/2;

            if(sumLtNum(A, mid, B)) {
                max = Math.max(max, mid);
                i=mid+1;
            } else j=mid-1;
        }

        return max;
    }

    public boolean sumLtNum(int[] A, int size, long B) {
        long sum = 0;
        for(int i=0; i<size; i++) sum += (long)A[i];
        if(sum > B) return false;

        for(int i=1; i<=A.length-size; i++) {
            sum = sum - A[i-1]+A[i+size-1];
            if(sum > B) return false;
        }

        return true;
    }
}
