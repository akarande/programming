package leetcode.adobe;

import java.util.*;
public class SubstringWithConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordSize = words[0].length();
        int size = words.length;
        int total = wordSize * size;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i + total <= s.length(); i++) {
            String curr = s.substring(i, i + total);
            Map<String, Integer> temp = new HashMap<>();
            for (int k = 0; k + wordSize <= curr.length();) {
                String str = curr.substring(k, k + wordSize);
                if (map.containsKey(str)) {
                    temp.put(str, temp.getOrDefault(str, 0) + 1);
                    k = k + wordSize;
                } else k++;
            }
            boolean shouldAdd = true;
            for (String key : map.keySet()) {
                if (temp.containsKey(key)  && temp.get(key).equals(map.get(key))) continue;
                else {
                    shouldAdd = false;
                    break;
                }
            }
            if (shouldAdd) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenation concatenation = new SubstringWithConcatenation();
        String s = "ababababab";
        String words[] = {"ababa","babab"};
        List<Integer> ans = concatenation.findSubstring(s, words);
        System.out.println("ans = " + Arrays.toString(ans.toArray()));
    }
}
