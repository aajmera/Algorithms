package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {

    Map<Integer, String> map = new HashMap<>();

    public static String countAndSay(int n) {

        if(n == 1) return "1";
        else {
            String prevNum = countAndSay(n-1);

            char currNum = prevNum.charAt(0);
            int count = 0;
            StringBuffer finalString = new StringBuffer("");

            for(char ch : prevNum.toCharArray()) {
                if(currNum == ch) count++;
                else {
                    finalString.append(count).append(Character.getNumericValue(currNum));
                    count = 1;
                    currNum = ch;
                }
            }
            finalString.append(count).append(Character.getNumericValue(currNum));
            return finalString.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
