package leetcode.practice2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akarande
 **/
public class ReformatString {
    public String reformat(String s) {
        List<Character> charList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for(Character c : s.toCharArray()) {
            if(Character.isDigit(c)) intList.add(c - '0');
            else charList.add(c);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, n1 = charList.size(), n2 = intList.size();
        while(i < n1 && j < n2) {
            if(n1 > n2) sb.append(charList.get(i++)).append(intList.get(j++));
            else sb.append(intList.get(j++)).append(charList.get(i++));
        }
        if(i < n1) {
            if(i + 1 >= charList.size()) sb.append(charList.get(i++));
            else return "";
        }
        if(j < n2) {
            if(j + 1 >= intList.size()) sb.append(intList.get(j++));
            else return "";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReformatString reformatString = new ReformatString();
        String s = "covid2019";
        reformatString.reformat(s);
    }
}
