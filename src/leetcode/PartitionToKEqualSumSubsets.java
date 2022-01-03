package leetcode;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();

        if(sum % k != 0) return false;

        Arrays.sort(nums);

        int target = sum / k;

        int left = 0, right = nums.length - 1;

        while (right >= left || k>0) {
            if(nums[right] > target) return false;
            int temp = target - nums[right--];
            while(temp != 0 && left <= right) {
                temp -= nums[left++];
                if(temp < 0) return false;
            }
            if(temp == 0) k--;
        }

        if(k == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {4,4,6,2,3,8,10,2,10,7};
        System.out.println(canPartitionKSubsets(nums, 4));
    }
}
