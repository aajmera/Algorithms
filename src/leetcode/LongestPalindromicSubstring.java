package leetcode;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        for(int i=s.length(); i>=1; i--) {
            for(int j=0; j<=s.length()-i; j++) {
                String str = s.substring(j, j+i);
                boolean isPalindrome = true;
                for(int z=0; z<str.length()/2;z++) {
                    if(str.charAt(z) != str.charAt(str.length()-z-1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if(isPalindrome) {
                    return str;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.print(longestPalindrome("bkuadixhrtfehvbjjzojfyhuqyckdeilnftnklylyssbjivhvnplrzwrgcnrciypvacbhdnglflipnlpzgivjfieunhzeaytshrintdwhbvbkhbsqbjxwhqrlneiwkmccdnfcvapmtqihzyyoiaoqgtxkpbqqdboaxmmsdjxvdrwbhdnemqmsikoksfvjjovrbgdtfgmhgryvvpunzrsluqzibsvyubyhqevpnfnszzriljpmoevpqacbvdcsgfzmnkhnshsvynxxncqyjxqazcttkvjnkuvykgdrquybvlpwzladpetocuphzkgfuutqcbnttwjmkkwbmbidcyauopcxmsarodcqabirbawtlgsytlflsiolxjghjmqrymadpzaetcchyvkaezeavjemubbquclhcjcmbwxphllhfnzfyewpyyiirgnohylfbtfddeohtifrqiiwpdtyqjyemqjlnpcwlsylxjuxtnmcrpdznbzschmnjxnldxpkbrikpfsfwhsarrfjueubvnztlwmognapvxwelyvueheqxtncpxhzwplaxqqrbmfmmqhohucxinxidxzhndvstideuwrisjgpwkgvsdxmlnfgqzzksflmjzckkyutrwptfvcawfbvqxlztstpoitdepexxiqtsdtjmssqbdinalsqkjjqkgilbfxajninuclquszwbmstcdbywfhhnierqsegafyfqzvmqockcowfqwbgfxvdxbqobditvowhtdeptljetgj"));
    }
}
