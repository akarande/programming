package leetcode.google.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author akarande
 **/
public class WordSearchII {

    class TrieNode {
        public Map<Character, TrieNode> charMap;
        public boolean isEnd;
        public TrieNode() {
            charMap = new HashMap<>();
            isEnd = false;
        }
    }
    void addWord(int pos, String word, TrieNode root) {
        if (pos >= word.length()) {
            root.isEnd = true;
            return;
        }
        TrieNode curr = root.charMap.get(word.charAt(pos));
        if(curr == null) {
            curr = new TrieNode();
            root.charMap.put(word.charAt(pos), curr);
        }
        addWord(pos + 1, word, curr);
    }

    TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {

        // Add all words
        for (String w : words) {
            addWord(0, w, root);
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            boolean[][] visited = new boolean [board.length][board[0].length];
            for (int j = 0; j < board[i].length; j++) {
                solve(i, j, "", board, root, result, visited);
            }
        }
        return new ArrayList<>(result);
    }

    void solve(int i, int j, String currWord, char[][] b, TrieNode root, Set<String> res, boolean[][] visited) {
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length || !root.charMap.containsKey(b[i][j]) || visited[i][j]) return;
        visited[i][j] = true;
        root = root.charMap.get(b[i][j]);
        currWord += b[i][j];
        if (root.isEnd) {
            res.add(currWord);
        }
        solve(i + 1, j, currWord, b, root, res, visited);
        solve(i - 1, j, currWord, b, root, res, visited);
        solve(i, j + 1, currWord, b, root, res, visited);
        solve(i, j - 1, currWord, b, root, res, visited);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        char b[][] = {{'a', 'a'}};
        //{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"aaa"};//{"oath","pea","eat","rain"};
        List<String> list = wordSearchII.findWords(b, words);
        list.stream().forEach(e -> System.out.print(e + " "));
    }
}
