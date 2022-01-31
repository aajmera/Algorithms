package self.practice;

import java.util.HashSet;

public class StringWithUniqueCharacters {
    public static boolean isUnique(String str) {
        HashSet<Character> stringChars = new HashSet<>();
        for(int i=0; i<str.length(); i++) {
            if(stringChars.contains(str.charAt(i))) return false;
            else stringChars.add(str.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abcdedfgh"));
    }
}
