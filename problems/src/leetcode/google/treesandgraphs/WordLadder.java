package leetcode.google.treesandgraphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author akarande
 **/
public class WordLadder {
    int solve(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int ans = 0;
        if (!set.contains(endWord) || beginWord.equals(endWord)) return ans;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return ans + 1;
                for (int j = 0; j < curr.length(); j++) {
                    char c[] = curr.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        c[j] = k;
                        String str = new String(c);
                        if (!curr.equals(str) && set.contains(str)) {
                            queue.offer(str);
                            set.remove(str);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        String s = "hit", t = "cog";
        String list[] = {"hot","dot","dog","lot","log","cog"};
        int ans = ladder.solve(s, t, Arrays.asList(list));
        System.out.println("ans = " + ans);
    }
}
