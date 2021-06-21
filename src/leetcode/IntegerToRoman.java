package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        Map<Integer, Character> romanMap = new HashMap<>();
        romanMap.put(1000, 'M');
        romanMap.put(500, 'D');
        romanMap.put(100, 'C');
        romanMap.put(50, 'L');
        romanMap.put(10, 'X');
        romanMap.put(5, 'V');
        romanMap.put(1, 'I');
        return getRoman(num, 1000, romanMap, "");
    }

    private static String getRoman(int num, int divisor, Map<Integer, Character> romanMap, String roman) {
        if(divisor == 0) {
            return roman;
        }

        int rem = num / divisor;

        if(rem == 9 || rem == 4) {
            roman = roman + romanMap.get(divisor) + romanMap.get((rem + 1) * divisor);
            return getRoman(num%divisor, divisor/10, romanMap, roman);
        }
        else if(rem >= 5) {
            roman += romanMap.get((5*divisor));
            num -= (5*divisor);
            return getRoman(num, divisor, romanMap, roman);
        }
        else {
            for(int i=0; i<rem; i++) roman += romanMap.get(divisor);
            return getRoman(num%divisor, divisor/10, romanMap, roman);
        }
    }

    public static void main(String[] args) {
        System.out.print(intToRoman(3444));
    }
}
