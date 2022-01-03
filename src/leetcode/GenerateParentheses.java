package leetcode;

import java.util.*;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        if(n == 1) return Arrays.asList(new String[] {"()"});

        Set<String> combinations = new HashSet<>();
        for(String curr : generateParenthesis(n-1)) {
            combinations.add("(" + curr + ")");
            combinations.add("()" + curr);
            combinations.add(curr + "()");
        }
        return new ArrayList<>(combinations);
    }

    public static void main(String[] args) {
        for(String str : generateParenthesis(0)) System.out.println(str);
    }
}
