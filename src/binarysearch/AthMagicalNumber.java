package binarysearch;

/**
 * You are given three positive integers, A, B, and C.
 *
 * Any positive integer is magical if divisible by either B or C.
 *
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 */

public class AthMagicalNumber {
    public int solve(int A, int B, int C) {

        long lcm = (B/gcd(B, C))*C;
        long mod = 1000000007;

        long lcmOcc = (lcm/B) + (lcm/C) - 1;

        long quot = A/lcmOcc;

        long i = ((lcm/B)*quot)+1;
        long j = ((lcm/C)*quot)+1;

        long rem = A%lcmOcc;

        if(rem == 0) return (int)(((quot%mod) * (lcm%mod))%mod);

        long result = 0;
        while(rem > 0) {
            rem--;

            if((long)B * i < (long)C*j) {
                result = (B * (i%mod))%mod;
                i++;
            } else {
                result = (C * (j%mod))%mod;
                j++;
            }
        }

        return (int)(result%mod);

    }

    public int gcd(int A, int B) {
        if(B==0) return A;

        return gcd(B, A%B);
    }
}
