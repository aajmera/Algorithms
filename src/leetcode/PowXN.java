package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PowXN {

    public static double myPow(double x, int n) {
        if(n==0) return 1; //if num = 0, return 1
        else if (n==1) return x; //if num =1, return number
        else if(n==-1) return 1/x;

        double val = 1.0; //create temp storage

        val = myPow(x, n/2);
        val *= val; // x^n = x^(n/2) * x^(n/2)

        if(n % 2 != 0) {
            if(n < 0) val *= 1/x;
            else val *= x; // if power was odd just multiple with 1 again
        }

        return val;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, -10));
    }

}
