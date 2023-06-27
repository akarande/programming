package leetcode.adobe;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    Map<Character, Integer> map;
    public int romanToInt(String s) {
        init();
        int res = 0, i = s.length() - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            res += map.get(c);
            if (c == 'V' && i - 1 >= 0 && s.charAt(i - 1) == 'I') res -= 2;
            else if (c == 'X' && i - 1 >= 0 && s.charAt(i - 1) == 'I') res -= 2;
            else if (c == 'L' && i - 1 >= 0 && s.charAt(i - 1) == 'X') res -= 20;
            else if (c == 'C' && i - 1 >= 0 && s.charAt(i - 1) == 'X') res -= 20;
            else if (c == 'D' && i - 1 >= 0 && s.charAt(i - 1) == 'C') res -= 200;
            else if (c == 'M' && i - 1 >= 0 && s.charAt(i - 1) == 'C') res -= 200;
            i--;
        }
        return res;
    }

    void init() {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String s = "MCMXCIV";
        int num = romanToInteger.romanToInt(s);
        System.out.println("num = " + num);
    }
}
