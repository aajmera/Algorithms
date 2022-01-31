package hackerrank.interviewpreparation.stacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> bracketStack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') bracketStack.push(ch);
            else {
                if(bracketStack.isEmpty()) return "NO";
                char lastBkt = bracketStack.pop();
                if((ch == '}' && lastBkt != '{')
                || (ch == ']' && lastBkt != '[')
                || (ch == ')' && lastBkt != '(')) return "NO";
            }
        }

        if(bracketStack.isEmpty()) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("())))"));
    }
}
