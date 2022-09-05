package binarysearch;

/*
 * Given a bitonic sequence A of N distinct elements,
 * write a program to find a given element B in the bitonic sequence in O(logN) time.
 */

public class SearchInBitonicSequence {

    public int solve(int[] A, int B) {
        int i=0, j=A.length-1, bp=-1;

        //find the bitonic point first
        while(i <= j) {
            int mid = (i+j)/2;

            // if value is greater than its left and right both, it is the bitonic point
            if(A[mid] > A[mid-1] &&
                    A[mid] > A[mid+1]) {
                bp = mid;
                break;
            } else if (A[mid] > A[mid-1] && //if the value is gt left and lt right, search right
                    A[mid] < A[mid+1]) i = mid+1;
            else j = mid-1; //else search left
        }


        // in case bitonic point isn't found, return -1;
        if(bp == -1) return bp;

        // if value is greater than the bitonic point, return -1
        // as value at BP is supposed to be max
        if(B > A[bp]) return -1;

        // if bp is the required value, return
        if(A[bp] == B) return bp;

        //search in the left side using binary search
        i=0; j=bp-1;
        while(i<=j) {
            int mid = (i+j)/2;

            if(A[mid] == B) return mid;
            else if(A[mid]>B) j=mid-1;
            else i=mid+1;
        }

        // if not found, search on the right side using binary search
        i=bp+1; j=A.length-1;

        while(i<=j) {
            int mid = (i+j)/2;
            if(A[mid] == B) return mid;
            else if(B>A[mid]) j=mid-1;
            else i=mid+1;
        }

        // return -1 if not found
        return -1;
    }
}
