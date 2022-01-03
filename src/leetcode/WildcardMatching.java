package leetcode;

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int j = 0, i = 0;
        for(; i<p.length() && j<s.length(); i++) {
            char currentChar = p.charAt(i);
            if(currentChar == '?') j++;
            else if(currentChar == '*') {
                if(i == p.length()-1) return true;
                else {
                    char nextChar = p.charAt(++i);
                    boolean matched = false;
                    while(!matched) {
                        if(s.charAt(j++) == nextChar) matched = true;
                    }
                    if(!matched) return false;
                }
            } else {
                if(s.charAt(j++) != currentChar) return false;
            }
        }

        if(i==p.length() && j==s.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("acdcb", "a*c?b"));
    }
}
