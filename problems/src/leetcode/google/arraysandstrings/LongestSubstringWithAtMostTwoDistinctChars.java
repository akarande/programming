package leetcode.google.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akarande
 **/
public class LongestSubstringWithAtMostTwoDistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int currLen = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() <= 2) currLen = Math.max(currLen, (end - start + 1));
            while (map.size() > 2) {
                char t = s.charAt(start++);
                map.put(t, map.getOrDefault(t, 0) - 1);
                if (map.get(t) <= 0) map.remove(t);
                if (map.size() <= 2) {
                    currLen = Math.max(currLen, (end - start + 1));
                }
            }
            end++;
        }
        return currLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctChars substringWithAtMostTwoDistinctChars = new LongestSubstringWithAtMostTwoDistinctChars();
        String s = "baacccacacabcaabbbbc";
        int result = substringWithAtMostTwoDistinctChars.lengthOfLongestSubstringTwoDistinct(s);
        System.out.println("result = " + result);
    }
}
