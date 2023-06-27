package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author akarande
 **/
public class SpecialBinaryString {
    public String makeLargestSpecial(String S) {
        if(S == null || S.length() <= 2) return S;
        Stack<List<String>> stack = new Stack<>();
        stack.push(new ArrayList<>());
        for(char c : S.toCharArray()) {
            if(c == '1') {
                stack.push(new ArrayList<>());
            } else {
                List<String> curr = stack.pop();
                Collections.sort(curr, Comparator.reverseOrder());
                String result = getStr(curr);
                stack.peek().add("1" + result + "0");
            }
        }
        List<String> ans = stack.peek();
        Collections.sort(ans, Comparator.reverseOrder());
        return getStr(ans);
    }

    private String getStr(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for(String curr : list) {
            sb.append(curr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SpecialBinaryString specialBinaryString = new SpecialBinaryString();
        String[] s = {"11011000", "1010101100"};
        for(int i = 0; i < s.length; i++) {
            String ans = specialBinaryString.makeLargestSpecial(s[i]);
            System.out.println("ans = " + ans);
        }
    }
}
