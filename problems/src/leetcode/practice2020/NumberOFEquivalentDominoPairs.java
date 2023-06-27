package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author akarande
 **/
public class NumberOFEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for(int[] d : dominoes) {
            String key = new String(Math.min(d[0], d[1]) + "-" + Math.max(d[0], d[1]));
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        for(String key : map.keySet()) {
            res += map.get(key) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        /*leetcode.practice2020.NumberOFEquivalentDominoPairs dominoPairs = new leetcode.practice2020.NumberOFEquivalentDominoPairs();
        int[][] arr = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        int ans = dominoPairs.numEquivDominoPairs(arr);
        System.out.println("ans = " + ans);*/

        String pattern = "\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?";
        //"([^\"]\\S*|\".+?\")*\\s+([^\"]\\S*|\".+?\")*";//"((\"[^\"]+?\")|('[^']+?')|([^\\s]+?))\\s++";///"(([\"]*\"*)*\\s+)";
        String str = "SM_EventName__c == \"Databas'e Offline\"" + " ";
        str = "SM_SourceDomain__c == \"MC-SCOM\"";
        str = "SM_ElementName__c == \"virtualmanagerdb\"";
        str = "SM_EventName__c == \"Database Offline\"";
            //"SM_ElementName__c == \"virtualmanagerdb\" AND SM_EventName__c == \"Database Offline\")" + " ";
        /*List<String> strings = splitExpression(str);
        strings.stream().forEach(s -> System.out.println("s = " + s));*/
        String[] a = str.split(pattern);
        for(int i = 0; i < a.length; i++) {
            System.out.println("a = " + a[i]);
        }
        /*Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(str);
        for(int i = 0; i < str.length(); i++) {
            matcher.region(i, str.length());
            if (matcher.lookingAt()) {
                String t = matcher.group(1);
                if (t.startsWith("\"") && str.endsWith("\"")) {
                    t = t.substring(1, str.length() - 1);
                }
                System.out.println(i + " = " + t);
                i += matcher.group(0).length() - 1;
            }
        }*/
    }


    private static List<String> splitExpression(String expr) {
        boolean isQuotes = false;
        List<String> ans = new ArrayList<>();
        int size = expr.length();
        for(int i = 0; i < expr.length();) {
            StringBuilder sb = new StringBuilder();
            if (expr.charAt(i) == '\"') isQuotes = !isQuotes;
            if((i == 0 && expr.charAt(i) != ' ') || (i > 0 && !isQuotes && expr.charAt(i) != ' ' && expr.charAt(i) == ' ') || (i > 0 && isQuotes)) {
                int j = i;
                while(j < size) {
                    sb.append(expr.charAt(j++));
                }
                ans.add(sb.toString());
                i = j;
            } else {
                i++;
            }
        }
        return ans;
    }
}
