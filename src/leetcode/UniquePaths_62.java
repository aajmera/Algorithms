package leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths_62 {

    static int[][] stepsArray = new int[100][100];

    public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        String key = m + "_" + n;
        if(stepsArray[m-1][n-1] != 0) return stepsArray[m-1][n-1];

        int steps = uniquePaths(Math.max(1, m-1), n)
                + uniquePaths(m, Math.max(1, n-1));
        stepsArray[m-1][n-1] = steps;
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(60, 60));
    }
}
