package leetcode.practice2020;

import java.util.*;

/**
 * @author akarande
 **/

public class SlidingWindow {

    public String minWindow(String text, List<String> words) {
        if (text == null || text.length() == 0) return new String();

        Set<String> set = new HashSet<>();
        for (String w : words) set.add(w);

        Map<String, Integer> map = new HashMap<>();
        String[] arr = text.split("\\s+");
        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        while (end < arr.length) {
            String curr = arr[end];
            if(!set.contains(curr)) { end++; continue;}
            if (set.contains(curr)) {
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            }
            // If you all complete window
            while (isAllWords(map) && start < end) {
                minLen = Math.min(minLen, (end - start + 1));
                System.out.println("current minLen " + minLen);
                minStart = start;
                String beginStr = arr[start];
                if (map.containsKey(beginStr)) {
                    map.put(beginStr, map.get(beginStr) - 1);
                    //if(map.get(beginStr) == 0) map.remove(beginStr);
                }
                start++;
            }
            end++;
        }
        StringBuilder sb = new StringBuilder();
        System.out.println("minLen " + minLen);
        for (int i = minStart; i <= minStart + minLen; i++) {
            sb.append(arr[i] + " ");
        }
        String ans = sb.toString().trim();
        return ans;
    }


    boolean isAllWords(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            if (map.get(key) == 0) return false;
        }
        return true;
    }

    public static void main(String args[]) throws Exception {
        SlidingWindow slidingWindow = new SlidingWindow();
        String text = "In a small dog park a big dog jumping over a small dog caused a big laugh";
        List<String> words = new ArrayList<>();
        words.add("small");
        words.add("big");
        words.add("dog");
        String result = slidingWindow.minWindow(text, words);
        System.out.println(result);
        System.out.println("done");
    }
}
