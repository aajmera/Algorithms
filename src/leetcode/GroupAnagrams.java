package leetcode;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str : strs) {
            int[] strIntMap = new int[26];
            for(char c : str.toCharArray()) strIntMap[c-97]++;
            String stringRep = Arrays.toString(strIntMap);
            if(anagramMap.containsKey(stringRep)) anagramMap.get(stringRep).add(str);
            else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                anagramMap.put(stringRep, anagrams);
            }
        }

        return new ArrayList<>(anagramMap.values());

    }

    public static void main(String[] args) {
        String[] strs = new String[6];
        strs[0] = "eat";
        strs[1] = "tea";
        strs[2] = "tan";
        strs[3] = "ate";
        strs[4] = "nat";
        strs[5] = "bat";

        groupAnagrams(strs);
    }
}
