package leetcode;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;

        int i=0, j=height.length-1;

        while (i!=j) {
            int tempArea = (j-i) * (height[j] > height[i] ? height[i] : height[j]);
            if(tempArea > maxArea) maxArea = tempArea;

            if(height[j] > height[i]) i++;
            else j--;
        }

        return maxArea;
    }
}
