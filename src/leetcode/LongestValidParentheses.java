package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Integer> charStack = new Stack<>();
        charStack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') charStack.push(i);
            else if (!charStack.isEmpty()) {
                charStack.pop();
                if(!charStack.isEmpty()) maxLength = Math.max(maxLength, (i-charStack.peek()));
                else charStack.push(i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.print(longestValidParentheses("(()())"));
    }
}
