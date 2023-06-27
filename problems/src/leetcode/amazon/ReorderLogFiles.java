package leetcode.amazon;

import java.util.*;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Map<String, String > map = new HashMap<>();
        List<String> list2 = new ArrayList<>();
        for (String s : logs) {
            String value = s.substring(s.indexOf(" ") + 1);
            if (Character.isDigit(value.charAt(0))) list2.add(s);
            else map.put(s, value);
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (x, y) -> {
            if (map.get(x).equals(map.get(y))) return x.compareTo(y);
            return map.get(x).compareTo(map.get(y));
        });
        String ans[] = new String[logs.length];
        int i = 0;
        for (i = 0; i < keys.size(); i++) {
            ans[i] = keys.get(i);
        }
        for (int k = 0; k < list2.size(); k++) ans[i + k] = list2.get(k);
        return ans;
    }

    public static void main(String[] args) {
        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        String logs[] = {"dig231 8 1 5 1","let1 art can","dig872 3 6","let2 own kit dig","let3 art zero"};//{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        String[] ans = reorderLogFiles.reorderLogFiles(logs);
        for (String t : ans) {
            System.out.println("ans = " + t);
        }
    }
}
