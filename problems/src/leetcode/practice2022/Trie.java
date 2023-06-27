package leetcode.practice2022;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    class TrieNode {

        Map<Character, TrieNode> charMap;
        boolean isEndOfWord;

        public TrieNode() {
            this.charMap = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

        public TrieNode root;

        public void add(String word) {
            addInternal(0, word, root);
        }

        private void addInternal(int pos, String word, TrieNode root) {
            if (pos >= word.length()) {
                root.isEndOfWord = true;
                return;
            }
            TrieNode curr = root.charMap.get(word.charAt(pos));
            if (curr == null) {
                curr = new TrieNode();
                root.charMap.put(word.charAt(pos), curr);
            }
            addInternal(pos + 1, word, curr);
        }

        public boolean find(String word) {
            return findInternal(0, word, root);
        }

        private boolean findInternal(int pos, String word, TrieNode root) {
            if (pos >= word.length()) return root.isEndOfWord;
            TrieNode curr = root.charMap.get(word.charAt(pos));
            if (curr == null) return false;
            return findInternal(pos + 1, word, curr);
        }

        public boolean startsWith(String word) {
            return startsWithInternal(0, word, root);
        }

        private boolean startsWithInternal(int pos, String word, TrieNode root) {
            if (pos >= word.length()) return true;
            TrieNode curr = root.charMap.get(word.charAt(pos));
            if (curr == null) return false;
            return startsWithInternal(pos + 1, word, curr);
        }

        public static void main(String[] args) {
            String word[] = {"story", "fleet", "leetcode"};
            String findWords[] = {"fleet", "car", "leetcode"};
            String prefix[] = {"st", "ced", "fe", "lee"};
            Trie trie = new Trie();
            trie.root = trie.new TrieNode();
            for (int i = 0; i < word.length; i++) trie.add(word[i]);
            for (int i = 0; i < findWords.length; i++) {
                System.out.println(findWords[i] + " is found ? : " + trie.find(findWords[i]));
            }
            for (int i = 0; i < prefix.length; i++) {
                System.out.println(prefix[i] + " is valid prefix ? : " + trie.startsWith(prefix[i]));
            }
        }
}
