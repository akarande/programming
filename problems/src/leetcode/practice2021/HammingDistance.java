package leetcode.practice2021;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author akarande
 **/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        while (x > 0) {
            a1.add(x % 2);
            x /= 2;
        }

        while (y > 0) {
            a2.add(y % 2);
            y /= 2;
        }
        while (a1.size() < a2.size()) {
            a1.add(0);
        }
        while (a2.size() < a1.size()) {
            a2.add(0);
        }
        int i = 0, count = 0;
        while(i < a1.size() && i < a2.size()) {
            if (!a1.get(i).equals(a2.get(i))) count++;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        /*HammingDistance hammingDistance = new HammingDistance();
        int result = hammingDistance.hammingDistance(4, 1);
        System.out.println("result = " + result);*/

        Map<String, String> keywords = new HashMap<>();
        keywords.put("{", "\\{");
        keywords.put("}", "\\}");
        keywords.put("[", "\\[");
        keywords.put("]", "\\]");
        /*keywords.put("(", "\\(");
        keywords.put(")", "\\)");
        keywords.put("$", "\\$");
        keywords.put("#", "\\#");
        keywords.put("!", "\\!");
        keywords.put("~", "\\~");
        keywords.put("`", "\\`");
        keywords.put("'", "\\'");
        keywords.put(";", "\\;");
        keywords.put(".", "\\.");
        keywords.put(":", "\\:");
        keywords.put("/", "\\/");
        keywords.put("?", "\\?");
        keywords.put(">", "\\>");
        keywords.put("<", "\\<");
        keywords.put(",", "\\,");
        keywords.put("+", "\\+");
        keywords.put("=", "\\=");
        keywords.put("-", "\\-");
        keywords.put("*", "\\*");
        keywords.put("&", "\\&");
        keywords.put("^", "\\^");
        keywords.put("%", "\\%");
        keywords.put("@", "\\@");*/
        String t = "component CONTAINS \"Let's GO!!!{}[]\" AND Severity == 1 OR component CONTAINS \"Let's GO!!!{}[]\" AND Component CONTAINS \"SUNRISE\"";
        /*String regex = new String();
        for (String key : keywords.keySet()) {
            regex = regex.replace(key, keywords.get(key));
        }
        String res = t.replaceAll(regex, "1");
        System.out.println("res = " + res);*/
        String s = "component CONTAINS \"Let's GO!!!{}[]\"";
        while(t.contains(s)) {
            String res = t.replace(s, "1");
            System.out.println(res);
            t = res;
        }

        /*String s3 = "name CONTAINS \"Argus\" AND status == \"ACTIVE\" OR (description NOT_EQUAL \"Test\" AND description == \"uklul\")";
        Pattern regex = Pattern.compile("[\\{|\\}|\\(|\\)|\\[|\\]]*");
        Matcher matcher = regex.matcher(s);
        System.out.println("matcher.find() = " + matcher.find());
        System.out.println("matcher.group(1) = " + matcher.group(1));*/
    }
}
