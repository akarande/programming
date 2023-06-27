package leetcode.practice2022;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int begin = 0, end = 0, max = 0;
        while (end < s.length()) {
            char curr = s.charAt(end);
            if (!seen.contains(curr)) {
                seen.add(curr);
                max = Math.max(max, seen.size());
                end++;
            } else {
                seen.remove(s.charAt(begin++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        LongestSubstringWithoutRepeatingCharacters substringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int result = substringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        System.out.println("result = " + result);
    }
}
