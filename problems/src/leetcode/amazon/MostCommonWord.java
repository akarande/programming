package leetcode.amazon;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String p[] = paragraph.split("[\\s+|!|\\?|,|;|\\.]");
        int max = 0;
        String maxWord = new String();
        for (String w : p) {
            if (w.length() > 0) {
                w = w.toLowerCase();
                if (w.endsWith("!") || w.endsWith("?") || w.endsWith("'") || w.endsWith(",") || w.endsWith(";") || w.endsWith("."))
                    w = w.substring(0, w.length() - 1);
                if (!set.contains(w)) {
                    map.put(w, map.getOrDefault(w, 0) + 1);
                    if (max < map.get(w)) {
                        max = map.get(w);
                        maxWord = w;
                    }
                }
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String para = "a, a, a, a, b,b,b,c, c";
        String banned[] = {"a"};
        String ans = mostCommonWord.mostCommonWord(para, banned);
        System.out.println("ans = " + ans);
    }
}
