package leetcode.google.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akarande
 **/
public class FindAndReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, NewString> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], new NewString(sources[i], targets[i]));
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (map.containsKey(i) && s.startsWith(map.get(i).source, i)) {
                ans.append(map.get(i).target);
                i += map.get(i).source.length();
            } else {
                ans.append(s.charAt(i++));
            }
        }
        return ans.toString();
    }
    class NewString {
        String source, target;
        int index;
        public NewString(String s, String t) {
            this.source = s;
            this.target = t;
        }
    }

    public static void main(String[] args) {
        FindAndReplaceString replaceString = new FindAndReplaceString();
        String s = "abcd", sources[] = {"ab", "ec"}, targets[] = {"eee", "fff"};
        int indices[] = {0, 2};
        String result = replaceString.findReplaceString(s, indices, sources, targets);
        System.out.println("result = " + result);
    }
}
