package leetcode.practice2020;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class SmallestDistinctCharacters {
    public String smallestSubsequence(String text) {
        if(text == null || text.length() < 2) return text;
        int n = text.length();

        Set<Character> set = new HashSet<>();
        for(Character c : text.toCharArray()) set.add(c);
        String min = new String();
        for(int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for(int i = j; i < n; i++) {
                if(sb.length() == set.size()) min = sb.toString().compareTo(min) < 0 ? sb.toString() : min;
                else {
                    char curr = text.charAt(i);
                    if(sb.indexOf(String.valueOf(curr)) == -1) sb.append(curr);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "cdadabcc";
        SmallestDistinctCharacters smallestDistinctCharacters = new SmallestDistinctCharacters();
        String ans = smallestDistinctCharacters.smallestSubsequence(s);
        System.out.println("ans = " + ans);
    }
}
