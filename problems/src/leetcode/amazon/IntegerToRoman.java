package leetcode.amazon;

import java.util.*;

public class IntegerToRoman {
    Map<Integer, String> map;
    public String intToRoman(int num) {
        init();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int ans[] = new int[4];
        while (num > 0 && k < ans.length) {
            int curr = num % 10;
            System.out.println("CURR " + curr);
            ans[k] = (int)(curr * Math.pow(10, k));
            num /= 10;
            k++;
        }
        System.out.println(Arrays.toString(ans));
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, Comparator.reverseOrder());
        for (int i = 0; i < ans.length; i++) {
            int t = ans[i];
            StringBuilder temp = new StringBuilder();
            while (t > 0) {
                for (Integer x : keys) {
                    if (x <= t) {
                        while (t >= x) {
                            t = t - x;
                            temp.append(map.get(x));
                        }
                    }
                }
            }
            sb.insert(0, temp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        int num = 660;
        String ans = integerToRoman.intToRoman(num);
        System.out.println("ans = " + ans);
    }

    void init() {
        map = new HashMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
}
