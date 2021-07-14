package leetcode;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int water = 0;
        for(int i=1; i<height.length-1; i++) {
            int currentHeight = height[i];
            int leftMax = currentHeight;
            int rightMax = currentHeight;
            for(int j=0; j<i ;j++) leftMax = Math.max(height[j], leftMax);
            for(int j=(i+1); j<height.length; j++) rightMax = Math.max(height[j], rightMax);

            water += Math.min(leftMax, rightMax) - currentHeight;
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,3}));
    }
}
