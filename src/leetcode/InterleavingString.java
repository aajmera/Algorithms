package leetcode;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(Math.abs(s1.length() - s2.length()) > 1) return false;
        if(s3.length() != (s1.length() + s2.length())) return false;
        if(s1.length() == 0 && s2.equals(s3)) return true;
        if(s2.length() == 0 && s1.equals(s3)) return true;

        int p1 = 0, p2 = 0, p3 = 0;

        while(p1 < s1.length() || p2 < s2.length()) {
            if(p1 < s1.length() &&
                    s3.charAt(p3) == s1.charAt(p1)) p1++;
            else if(p2 < s2.length() &&
                    s3.charAt(p3) == s2.charAt(p2)) p2++;
            else
                return false;

            p3++;
        }

        return true;
    }

    public static void main(String[] args) {
        char ch = 'a';
        System.out.println(ch - 96);
    }
}
