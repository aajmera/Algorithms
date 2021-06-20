package leetcode;

public class ReverseSignedInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int reverse = 0;
        int max = Integer.MAX_VALUE/10;
        int min = Integer.MIN_VALUE/10;
        while (x != 0) {
            if(reverse > max ||
            reverse < min) {
                return 0;
            }
            reverse = (reverse * 10) + x%10;
            x/=10;
        }
        return reverse;
    }
}
