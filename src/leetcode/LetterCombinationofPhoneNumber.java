package leetcode;

import java.util.*;

public class LetterCombinationofPhoneNumber {

    static Map<String, List<String>> numCharMap = new HashMap<>();

    static {
        numCharMap.put("2", Arrays.asList(new String[]{"a", "b", "c"}));
        numCharMap.put("3", Arrays.asList(new String[]{"d", "e", "f"}));
        numCharMap.put("4", Arrays.asList(new String[]{"g", "h", "i"}));
        numCharMap.put("5", Arrays.asList(new String[]{"j", "k", "l"}));
        numCharMap.put("6", Arrays.asList(new String[]{"m", "n", "o"}));
        numCharMap.put("7", Arrays.asList(new String[]{"p", "q", "r", "s"}));
        numCharMap.put("8", Arrays.asList(new String[]{"t", "u", "v"}));
        numCharMap.put("9", Arrays.asList(new String[]{"w", "x", "y", "z"}));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new LinkedList<>();

        if(digits.length() == 1) return numCharMap.get(digits);
        else if (digits.length() > 1){
            List<String> combo = letterCombinations(digits.substring(1, digits.length()));
            numCharMap.get(digits.substring(0, 1)).stream()
                    .forEach(str1 -> {
                        combo.stream().forEach(str2 -> {
                            combinations.add(str1 + str2);
                        });
                    });
        }

        return combinations;
    }

    public static void main(String[] args) {
        for(String val : letterCombinations("777")) System.out.println(val);
    }
}
