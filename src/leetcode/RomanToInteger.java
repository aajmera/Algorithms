package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character, Integer> romanIntMap = new HashMap<>();
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);

        int currentVal = 0;
        int sum = 0;
        for(int i=s.length()-1; i>=0; i--) {
            int val = romanIntMap.get(s.charAt(i));
            if(currentVal <= val) {
                currentVal = val;
                sum += val;
            } else sum-= val;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MMMCDXLIV"));
    }
}
