package leetcode.practice2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author akarande
 **/
public class SpellChecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        /*Set<String> set = new HashSet<>(Arrays.asList(wordlist));
        String ans[] = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = getMatch1(queries[i], wordlist, set);
            if (ans[i].length() == 0) {
                ans[i] = getMatch2(queries[i], wordlist);
            }
        }
        return ans;*/
        //return solve(wordlist, queries);
        return solve2(wordlist, queries);
    }

    /*private String[] solve(String[] wordList, String[] queries) {
        Set<String> regularStr = new LinkedHashSet<>(Arrays.asList(wordList));
        Set<String> lowerCaseStr = Arrays.stream(wordList).map(word -> word.toLowerCase()).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<String> vowelChangeStr = Arrays.stream(wordList).map(word -> replaceVowels(word)).collect(Collectors.toCollection(LinkedHashSet::new));
        String ans[] = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (regularStr.contains(q))  ans[i] = q;
            else if (lowerCaseStr.contains(q)) ans[i] = q.toLowerCase();
            else if (vowelChangeStr.contains(replaceVowels(q))) ans[i] = wordList[i];
            else ans[i] = "";
        }
        return ans;
    }*/

    public String getMatch1(String word, String[] words, Set<String> set) {
        if (set.contains(word)) return word;
        for (int i = 0; i < words.length; i++) {
            if (word.equalsIgnoreCase(words[i])) return words[i];
        }
        return "";
    }

    public String getMatch2(String word, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == word.length()) {
                String s1 = replaceVowels(word);
                String s2 = replaceVowels(words[i]);
                if (s1.length() > 0 && s1.equalsIgnoreCase(s2)) {
                    return words[i];
                }
            }
        }
        return "";
    }

    private String replaceVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (Character c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append('a');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String[] solve2(String[] wordlist, String[] queries) {
        Set<String> set = new LinkedHashSet<>();
        Map<String, String> lowerCaseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            set.add(word);
            String lowerCaseWord = word.toLowerCase();
            lowerCaseMap.putIfAbsent(lowerCaseWord, word);
            vowelMap.putIfAbsent(replaceVowels(lowerCaseWord), word);
        }
        String ans[] = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = solve(queries[i], set, lowerCaseMap, vowelMap);
        }
        return ans;
    }

    private String solve(String word, Set<String> set, Map<String, String> lowerCaseMap, Map<String, String> vowelMap) {
        if (set.contains(word)) return word;
        String lowerCase = word.toLowerCase();
        if (lowerCaseMap.keySet().contains(lowerCase)) return lowerCaseMap.get(lowerCase);
        else if (vowelMap.keySet().contains(replaceVowels(lowerCase))) return vowelMap.get(replaceVowels(lowerCase));
        else return new String();
    }

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker();
        String wordList[] = /*{"YellOw"};*/{"KiTe","kite","hare","Hare"};
        String queries[] = /*{"yollow"};*/{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        String[] ans = spellChecker.spellchecker(wordList, queries);
        Arrays.stream(ans).forEach(word -> System.out.println(word));
    }
}
