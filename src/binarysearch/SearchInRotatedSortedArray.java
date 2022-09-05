package binarysearch;

/*
 * Given a sorted array of integers A of size N and an integer B.
 * array A is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * You are given a target value B to search. If found in the array, return its index otherwise, return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 */

public class SearchInRotatedSortedArray {

    public int search(final int[] A, int B) {
        //first find the rotation point
        int i=0, j=A.length-1, rp=-1;

        while(i<=j) {
            int mid = (i+j)/2;

            /*
             * If current element is greater than its neighbours
             * In case element is extreme end, check the available neighbour
             */
            if((mid==0 || A[mid]>A[mid-1]) &&
                    (mid==A.length-1 || A[mid]>A[mid+1])) {
                rp = mid;
                break;
            } else if(A[mid] > A[A.length-1]) i = mid+1;
            else j = mid-1;
        }

        //if no rotation point, binary search original array
        if(rp == -1) return binarySearch(A, B, 0, A.length-1);
        //if number is greater than end element, search btw 0 and rotation point
        else if(B>A[A.length-1]) return binarySearch(A, B, 0, rp);
        // if number is less than or equal to end, search btw rotation point+1 and end
        else return binarySearch(A, B, rp+1, A.length-1);
    }

    /*
     * Binary search between two positions given (inclusive)
     */
    public int binarySearch(int[] A, int B, int start, int end) {
        while(start <= end) {
            int mid = (start+end)/2;

            if(A[mid] == B) return mid;
            else if(B < A[mid]) end= mid-1;
            else start=mid+1;
        }

        return -1;
    }
}
