package binarysearch;

/**
 * The government wants to set up B distribution offices
 * across N cities for the distribution of food
 * packets. The population of the ith city is A[i].
 * Each city must have at least 1 office, and people can go to
 * an office of their own city. We want to maximize the minimum
 * number of people who can get food in any single office.
 */

public class FoodPacketsDistribution {
    public int solve(int[] A, int B) {
        //if num of offices < cities, return -1 as atleast one office in a city required
        if(B < A.length) return -1;

        //calculate total population
        long totalPop = 0;

        //min num of people is 1 (atleast 1 person in one office)
        //max number is min population (min population city having one office)
        int i = 1, j = Integer.MAX_VALUE;

        for(int num : A) {
            totalPop += num;
            j = Math.min(j, num);
        }

        //if total population < num of offices, atleast 1 office will have no employee
        if(totalPop < B) return 0;

        int result = 0;

        //binary search between min and max
        while(i <= j) {
            int mid = (i+j)/2;

            if(valid(A, mid, B)) {
                result = mid;
                i = mid+1;
            } else j = mid-1;
        }

        return result;
    }

    /**
     * check number of offices required >= B
     * @param A
     * @param mid
     * @param B
     * @return
     */
    public boolean valid(int[] A, int mid, int B) {
        int offices = 0;

        for(int num : A) offices += (num/mid);

        if(offices < B) return false;
        return true;
    }
}
