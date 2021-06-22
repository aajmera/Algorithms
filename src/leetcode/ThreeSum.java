package leetcode;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if(nums.length < 3) return Collections.emptyList();

        Arrays.sort(nums);

        if(nums[0] <= 0 && nums[nums.length-1] >= 0) {
            for(int i=0; i<nums.length-2 && nums[i] <= 0; i++)
                for(int j=(i+1), k=nums.length-1; j<k; ) {
                    if(nums[j] + nums[k] + nums[i] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++; k--;
                    } else if (nums[j] + nums[k] + nums[i] < 0) j++;
                    else k--;
                }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.print(threeSum(nums));
    }
}
