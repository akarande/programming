package leetcode.practice2020;

/**
 * @author akarande
 * 1358. Number of Substrings Containing All Three Characters
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 **/
public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int total = 0, n = s.length();
        for(int i = 0; i < n;) {
            int a = s.indexOf('a', i);
            int b = s.indexOf('b', i);
            int c = s.indexOf('c', i);
            if(a == -1 || b == -1 || c == -1) break;
            int currMax = Math.max(a, Math.max(b, c));
            total += (n - currMax);
            i = Math.min(a, Math.min(b, c)) + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        String s = "abc";//"aaacb";//"abcabc";
        NumberOfSubstringsContainingAllThreeCharacters numberOfSubstringsContainingAllThreeCharacters = new NumberOfSubstringsContainingAllThreeCharacters();
        int ans = numberOfSubstringsContainingAllThreeCharacters.numberOfSubstrings(s);
        System.out.println("ans = " + ans);
    }
}
