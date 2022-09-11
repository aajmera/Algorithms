package binarysearch;

/**
 * Given an array of integers A of size N and an integer B.
 *
 * The College library has N books. The ith book has A[i] number of pages.
 *
 * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
 *
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 *
 * NOTE: Return -1 if a valid assignment is not possible.
 */

public class AllocateBooks {
    public int books(int[] A, int B) {
        if(B > A.length) return -1;
        int i = 0, j = 0;

        for(int num : A) {
            j += num;
            i = Math.max(i, num);
        }

        int answer = 0;

        while(i <= j) {
            int mid = (i+j)/2;

            if(isValid(A, mid, B)) {
                answer = mid;
                j=mid-1;
            } else i=mid+1;
        }

        return answer;
    }

    public boolean isValid(int[] A, long size, long B) {
        long students = 1;
        long pages = 0;

        for(int num : A) {
            long currSize = num;
            if(pages + currSize <= size) {
                pages += currSize;
            } else {
                students++;
                pages = num;
            }
        }

        if(students > B) return false;
        return true;
    }
}
