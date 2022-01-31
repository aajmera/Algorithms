package leetcode;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public int search(int[] nums, int target, int start, int end) {
        if(end - start == 1) {
            if(nums[start] == target) return start;
            else return -1;
        }

        int checkIndex = (start + end) / 2;
        if(target == nums[checkIndex]) return checkIndex;
        else if (target < nums[checkIndex]) return search(nums, target, start, checkIndex);
        else return search(nums, target, checkIndex, end);
    }
}
