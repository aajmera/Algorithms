package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Integer finalAnswer = null;
        Integer diff = null;

        //sort the array first
        Arrays.sort(nums);

        //take the ith element
        for(int i=0; i<nums.length-2; i++) {
            /*
             * Iterate the array such that
             * - take the first and the last element after the ith element
             * - calculate the sum for these three values
             * - check if difference is lesser than previously found difference
             * - now see if sum < target, then pick next element of j
             * - else if sum > target, then pick previous element of k
             */
            for(int j=(i+1), k=nums.length-1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];
                int tempDiff = Math.abs(target-sum);
                if(tempDiff == 0) return target;
                else if(diff == null || tempDiff < diff) {
                    finalAnswer = sum;
                    diff = tempDiff;
                }

                if(sum < target) j++;
                else k--;
            }
        }

        return finalAnswer;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(threeSumClosest(nums, 1));
    }
}
