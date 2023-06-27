package leetcode.microsoft;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    Map<Character, Integer> map = new HashMap<>();

    public int romanToInt(String s) {
        init();
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            switch(curr) {
                case 'I':
                    result += map.get(curr);
                    break;
                case 'V':
                    result += map.get(curr);
                    if (i > 0 && s.charAt(i - 1) == 'I') result -= 2;
                    break;
                case 'X':
                    result += map.get(curr);
                    if (i > 0 && s.charAt(i - 1) == 'I') result -= 2;
                    break;
                case 'L':
                    result += map.get(curr);
                    if (i > 0 && s.charAt(i - 1) == 'X') result -= 20;
                    break;
                case 'C':
                    result += map.get(curr);
                    if (i > 0 && s.charAt(i - 1) == 'X') result -= 20;
                    break;
                case 'D':
                    result += map.get(curr);
                    if (i > 0 && s.charAt(i - 1) == 'C') result -= 200;
                    break;
                case 'M':
                    result += map.get(curr);
                    if (i > 0 && s.charAt(i - 1) == 'C') result -= 200;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String s[] = {"LVIII", "III", "MCMXCIV"};
        for (String t : s) {
            int value = romanToInteger.romanToInt(t);
            System.out.println("value = " + value);
        }
    }

    void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

    }
}
