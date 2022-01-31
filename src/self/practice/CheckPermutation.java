package self.practice;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public static boolean checkPermutation(String str1, String str2) {
        Map<Character, Integer> strCharCount = new HashMap<>();
        for(int i=0; i<str1.length(); i++) {
            char ch = str1.charAt(i);
            if(strCharCount.containsKey(ch))
                strCharCount.put(ch, strCharCount.get(ch)+1);
            else
                strCharCount.put(ch, 1);
        }

        for(int i=0; i<str2.length(); i++) {
            char ch = str2.charAt(i);
            if(!strCharCount.containsKey(ch)) return false;
            else if(strCharCount.get(ch) == 1) strCharCount.remove(ch);
            else strCharCount.put(ch, strCharCount.get(ch)-1);
        }

        if(strCharCount.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("anurag", "anura"));
    }
}
