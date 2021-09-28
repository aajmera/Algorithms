package leetcode;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;   //return dividend if dividing by 1
        else if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // return max value if min value/-1
        else if(divisor == -1) return dividend * -1;    //if divide by -1, return -1*dividend

        long count = 0;

        long finalSign = ((dividend > 0 && divisor > 0) ||
                (dividend <0 && divisor < 0)) ? 1 : -1; //calculate the final sign

        long tempDividend = dividend < 0 ? -1*(long)dividend : dividend;    //get abs value for dividend
        long tempDivisor = divisor < 0 ? -1*(long)divisor : divisor;    //get abs value for divisor

        while(tempDividend - tempDivisor >= 0) {
            count++; //calculate division
            tempDividend -= tempDivisor;
        }

        if(count * finalSign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) (count * finalSign);
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE, -2));
    }
}
