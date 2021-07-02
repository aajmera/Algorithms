package leetcode;

import java.util.Arrays;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        boolean isOnePresent = Arrays.stream(nums).anyMatch(num -> {
            return num == 1;
        });

        if(!isOnePresent) return 1;

        for(int i=0; i<nums.length; i++) if(nums[i] < 1 || nums[i] > nums.length) nums[i] = 1;

        Arrays.stream(nums).forEach(num -> {
            if(nums[Math.abs(num)-1] > 0) nums[Math.abs(num)-1] *= -1;
        });

        int i=0;
        while (i < nums.length)
            if(nums[i] > 0) return (i+1);
            else i++;
        return i+1;
    }

    public static void main(String[] args) {
        System.out.print(firstMissingPositive(new int[]{1,1,1,1,1,1}));
    }
}
