package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Integer finalAnswer = null;
        Integer diff = null;

        //sort the array first
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
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
