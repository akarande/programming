package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akarande
 **/
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int memo[] = new int[words.length];
        // Create a map of string to index for easier lookup
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        // Create a adjacency matrix for each index
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String curr = words[i];
            for(int j = 0; j < curr.length(); j++) {
                String temp = curr.substring(0, j) + curr.substring(j + 1);
                // A curr vertex can reach the next one if the new word is equal to curr word by removing one character
                if(map.containsKey(temp)) {
                    int index = map.get(temp);
                    List<Integer> edges = graph.getOrDefault(index, new ArrayList<>());
                    edges.add(i);
                    graph.put(index, edges);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < words.length; i++) {
            ans = Math.max(ans, dfs(i, graph, memo));
        }
        return ans;
    }

    private int dfs(int index, Map<Integer, List<Integer>> graph, int[] memo) {
        if(memo[index] > 0) return memo[index];
        memo[index] = 1;
        for(Integer curr : graph.getOrDefault(index, new ArrayList<>())) {
            if(curr == null) continue;
            memo[index] = Math.max(memo[index], dfs(curr, graph, memo) + 1);
        }
        return memo[index];
    }

    public static void main(String[] args) {
        String arr[] = {"a","b","ba","bca","bda","bdca"};
        LongestStringChain longestStringChain = new LongestStringChain();
        int strChain = longestStringChain.longestStrChain(arr);
        System.out.println("strChain = " + strChain);
    }
}
