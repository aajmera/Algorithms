package binarysearch;

import java.util.Arrays;

/**
 * Farmer John has built a new long barn with N stalls.
 * Given an array of integers A of size N where each element
 * of the array represents the location of the stall and
 * an integer B which represents the number of cows.
 *
 * His cows don't like this barn layout and become
 * aggressive towards each other once put into a stall.
 * To prevent the cows from hurting each other, John wants
 * to assign the cows to the stalls, such that the minimum
 * distance between any two of them is as large as possible.
 * What is the largest minimum distance?
 */

public class AggressiveCows {
    public int solve(int[] A, int B) {
        Arrays.sort(A);

        int i=1, j=A[A.length-1]-A[0];

        int result = 0;

        while(i <= j) {
            int mid = (i+j)/2;

            if(isVaiid(A, mid, B)) {
                result = mid;
                i = mid+1;
            } else j=mid-1;
        }

        return result;
    }

    public boolean isVaiid(int[] A, int dist, int B) {
        int cows = 1;
        int lastCow = 0;

        for(int i=0; i<A.length; i++) {
            if(A[i]-A[lastCow] >= dist) {
                lastCow = i;

                if(++cows == B) return true;
            }
        }

        return false;
    }
}
