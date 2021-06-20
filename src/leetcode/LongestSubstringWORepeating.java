package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestSubstringWORepeating{
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        Map<String, Integer> charMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));
            if(charMap.containsKey(ch) && charMap.get(ch) >= start) {
                if(i-start > max) {
                    max = i-start;
                }
                start = charMap.get(ch) + 1;
            }
            charMap.put(ch, i);
        }

        if(s.length()-start > max) {
            max = s.length()-start;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abcabcbb"));
    }
}
