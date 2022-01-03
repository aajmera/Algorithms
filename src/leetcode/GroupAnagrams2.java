package leetcode;

import java.util.*;

public class GroupAnagrams2 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String word = new String(chars);
            if(anagramMap.containsKey(word)) anagramMap.get(word).add(str);
            else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                anagramMap.put(word, anagrams);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }
}
