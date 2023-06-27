package leetcode.practice2022;

import java.util.*;

public class IndexPairsOfAStringTrie {

    class TrieNode {
        Map<Character, TrieNode> charMap;
        boolean isEnd;
        public TrieNode() {
            this.charMap = new HashMap<>();
            this.isEnd = false;
        }
    }
    public TrieNode add(int pos, String word, TrieNode head) {
        if (pos >= word.length()) {
            head.isEnd = true;
            return head;
        }
        TrieNode curr = head;
        if (curr == null) curr = new TrieNode();
        head.charMap.put(word.charAt(pos), curr);
        return add(pos + 1, word, curr);
    }

    public boolean hasWord(int pos, String word, TrieNode head) {
        if (pos >= word.length()) return head.isEnd;
        TrieNode currNode = head.charMap.get(word.charAt(pos));
        if (currNode == null) return false;
        return hasWord(pos + 1, word, currNode);
    }

    public boolean startsWith(int pos, String word, TrieNode head) {
        if (pos >= word.length()) return true;
        TrieNode currNode = head.charMap.get(word.charAt(pos));
        if (currNode == null) return false;
        return startsWith(pos + 1, word, currNode);
    }

    public int[][] indexPairs(String text, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            root = add(0, w, root);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            List<Integer> currList = new ArrayList<>();
            if (startsWith(0, text.substring(i, i + 1), root)) {
                for (int j = i; j < text.length(); j++) {
                    String currWord = text.substring(i, j);
                    while(hasWord(0, currWord, root)) {
                        currList.add(i);
                        currList.add(j);
                    }
                }
            }
            result.add(currList);
        }
        result.sort((a, b) -> {
            if (a.get(0) == b.get(0)) return a.get(1) - b.get(1);
            return a.get(0) - b.get(0);
        });
        int a[][] = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) a[i] = new int[] {result.get(i).get(0), result.get(i).get(1)};
        return a;
    }
    public static void main(String[] args) {
        String s = "thestoryofleetcodeandme", words[] = {"story","fleet","leetcode"};
        IndexPairsOfAStringTrie pairsOfAString = new IndexPairsOfAStringTrie();
        int[][] ans = pairsOfAString.indexPairs(s, words);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("[" + ans[i][0] + "," + ans[i][1] + "]");
        }
    }
}
