package leetcode;

public class SquaresOfSortedArray {

    public static int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];

        int leftPointer = -1;
        int rightPointer = nums.length;

        if(nums[0] >= 0) {
            rightPointer = 0;
        }
        else if (nums[nums.length-1] < 0) {
            leftPointer = nums.length-1;
        }
        else {
            for(int i=0; i<nums.length-1; i++) {
                if(nums[i] < 0 && nums[i+1] >= 0) {
                    leftPointer = i;
                    rightPointer = i+1;
                    break;
                }
            }
        }

        int i=0;

        while(leftPointer >= 0 && rightPointer < nums.length) {
            if(Math.abs(nums[leftPointer]) < nums[rightPointer]) {
                squares[i++] = nums[leftPointer] * nums[leftPointer];
                leftPointer--;
            } else {
                squares[i++] = nums[rightPointer] * nums[rightPointer];
                rightPointer++;
            }
        }

        if(leftPointer == -1) {
            for(int j=rightPointer; j<nums.length; j++)
                squares[i++] = nums[j] * nums[j];
        }

        if(rightPointer == nums.length) {
            for(int j=leftPointer; j>=0; j--)
                squares[i++] = nums[j] * nums[j];
        }

        return squares;

    }

    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[]{2, 3, 4, 5}));
    }

}
