package leetcode.practice2022;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : t.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);

        int total = t.length(), currCount = 0;
        int left = -1, right = -1;
        Map<Character, Integer> map1 = new HashMap<>();
        String ans = new String();
        while (true) {
            boolean loop1 = false, loop2 = false;
            // acquire
            while (right < s.length() - 1 && currCount < total) {
                right++;
                char c = s.charAt(right);
                map1.put(c, map1.getOrDefault(c, 0) + 1);
                if (map1.getOrDefault(c, 0) <= map2.getOrDefault(c, 0)) currCount++;
                loop1 = true;
            }

            // update answer and release
            while (left < right && currCount == total) {
                String currStr = s.substring(left + 1, right + 1);
                if (ans.length() == 0 || ans.length() > currStr.length()) ans = currStr;
                left++;
                char c = s.charAt(left);
                if (map1.get(c) == 1) map1.remove(c);
                else map1.put(c, map1.getOrDefault(c, 0) - 1);
                if (map1.getOrDefault(c, 0) < map2.getOrDefault(c, 0)) currCount--;
                loop2 = true;
            }
            if (loop1 == false && loop2 == false) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        String s = "ADOBECODEBANC", t = "ABC";
        String ans = minWindow.minWindow(s, t);
        System.out.println("ans = " + ans);
    }
}
