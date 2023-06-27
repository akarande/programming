package leetcode.roblox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOfOccurrencesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int a[] = new int[26];
        Set<Character> set = new HashSet<>();
        Map<String, Integer> countMap = new HashMap<>();
        int k = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            a[curr - 'a']++;
            set.add(curr);
            if (isValid(set, s.substring(k, i + 1), maxLetters, minSize, maxSize)) {
                /*(set.size() <= maxLetters && (i - k) >= minSize && (i - k) <= maxSize)*/
                String key = s.substring(k, i + 1);
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                System.out.println("Key -> " + key + " Value -> " + countMap.get(key));
            } else if ((set.size() > maxLetters || (i - k + 1) > maxSize) && k < i) {
                while ((set.size() > maxLetters || (i - k + 1) > maxSize) && k < i) {
                    char c = s.charAt(k++);
                    a[c - 'a']--;
                    if (a[c - 'a'] == 0) set.remove(c);
                }
                i--;
            }
            /*if (set.size() <= maxLetters && (i - k + 1) >= minSize && (i - k + 1) <= maxSize) {
                String key = s.substring(k, i + 1);
                //System.out.println("Key : " + key);
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                System.out.println("Key -> " + key + " Value -> " + countMap.get(key));
            } else {
                while ((set.size() > maxLetters || (i - k + 1) > maxSize) && k < i) {
                    char c = s.charAt(k++);
                    a[c - 'a']--;
                    if (a[c - 'a'] == 0) set.remove(c);
                }
            }*/
        }
        /*for (String key : countMap.keySet()) {
            System.out.println("Key -> " + key + " Value -> " + countMap.get(key));
        }*/
        int ans = 0;
        for (String key : countMap.keySet()) ans = Math.max(ans, countMap.get(key));
        return ans;
    }

    private boolean isValid(Set<Character> set, String curr, int maxLetters, int minSize, int maxSize) {
        return (set.size() <= maxLetters && curr.length() >= minSize && curr.length() <= maxSize);
    }

    public static void main(String[] args) {
        MaximumNumberOfOccurrencesOfASubstring substring = new MaximumNumberOfOccurrencesOfASubstring();
        String s = "aababcaab";
        int ans = substring.maxFreq(s, 2, 3, 4);
        System.out.println("ans = " + ans);
    }
}
