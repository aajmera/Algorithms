package leetcode;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;

        int firstNum = totalLength%2 ==0? totalLength/2 : (totalLength/2)+1;
        int nextNum = totalLength%2 ==0? totalLength/2+1 : (totalLength/2)+1;

        int i=0, j=0;
        int first = 0, second = 0;
        int count = 0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] <= nums2[j]) {
                count++;
                if(count == firstNum) {
                    first = nums1[i];
                }
                if (count == nextNum) {
                    second = nums1[i];
                    return (first + second)/2;
                }
                i++;
            } else {
                count++;
                if(count == firstNum) {
                    first = nums2[j];
                }
                if (count == nextNum) {
                    second = nums2[j];
                    return (first + second)/2;
                }
                j++;
            }
        }

        if(i<nums1.length) {
          if(count < firstNum) {
              first = nums1[i+firstNum-count-1];
          }
          second = nums1[i+nextNum-count-1];
        }

        if(j<nums2.length) {
            if(count < firstNum) {
                first = nums2[j+firstNum-count-1];
            }
            second = nums2[j+nextNum-count-1];
        }


        return (double)(first+second)/2;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
    }
}
