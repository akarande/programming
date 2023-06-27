package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akarande
 **/
public class SearchSuggestionWords {

        class TrieNode {
            boolean isEndWord;
            Map<Character, TrieNode> charMap;
            List<String> list;
            public TrieNode() {
                isEndWord = false;
                charMap = new HashMap<>();
                list = new ArrayList<>();
            }
        }

        /*class TrieNode
    {
        Map<Character, TrieNode> children;
        boolean isEow;
        List<String> list ;
        TrieNode()
        {
            children = new HashMap();
            isEow = false;
            list = new ArrayList();
        }
    }*/

        private TrieNode root = new TrieNode();

        public TrieNode add(String word) {
            addNode(0, word, root);
            return root;
        }

        private void addNode(int pos, String word, TrieNode root) {
            if(pos >= word.length()) {
                root.isEndWord = true;
                return;
            }
            TrieNode currNode = root.charMap.get(word.charAt(pos));
            if(currNode == null) {
                currNode = new TrieNode();
                root.charMap.put(word.charAt(pos), currNode);
            }
            if(currNode.list.size() < 3) currNode.list.add(word);
            addNode(pos + 1, word, currNode);
        }

    /*public void insert(String word)
    {
        TrieNode current = root;
        for(char ch : word.toCharArray())
        {
            TrieNode node = current.children.get(ch);
            if(node == null)
            {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            if(node.list.size() < 3)
                node.list.add(word);
            current = node;
        }

        current.isEow = true;
    }*/

        private List<String> getNode(String word) {
            return getNodeInternal(0, word, root);
        }

        private List<String> getNodeInternal(int pos, String word, TrieNode root) {
            if(pos >= word.length()) {
                return root.list;
            }
            TrieNode curr = root.charMap.get(word.charAt(pos));
            if(curr == null) return new ArrayList<>(root.list);
            return getNodeInternal(pos + 1, word, curr);
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            for(String s : products) {
                root = add(s);
            }
            List<List<String>> answer = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(char c : searchWord.toCharArray()) {
                sb.append(c);
                List<String> curr = getNode(sb.toString());
                answer.add(curr);
            }
            return answer;
        }

    public static void main(String[] args) {
        SearchSuggestionWords searchSuggestionWords = new SearchSuggestionWords();
        String products[] = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> lists = searchSuggestionWords.suggestedProducts(products, searchWord);
        lists.stream().forEach(e -> {
            System.out.println(String.join(", ", e));
        });
    }



    /*class Solution {
        TrieNode root = new TrieNode();
        List<List<String>> result;

        public List<List<String>> search(String word)
        {
            List<List<String>> result = new ArrayList();
            for(int i = 0 ; i < word.length(); i++)
                result.add(new ArrayList<String>());

            TrieNode current = root;
            for(int i = 0; i < word.length(); i++)
            {
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                if(node == null)
                {
                    return result;
                }
                else{
                    result.set(i, node.list);
                    current = node;
                }
            }
            return result;
        }
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            for(String word : products)
                insert(word);
            return search(searchWord);
        }
    }*/
}
