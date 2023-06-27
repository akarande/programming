package leetcode.practice2022;
import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) map.put(keyboard.charAt(i), i);
        int time = 0, prev = 0;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            int val = map.get(curr);
            time += Math.abs(prev - val);
            prev = val;
        }
        return time;
    }

    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba";
        SingleRowKeyboard singleRowKeyboard = new SingleRowKeyboard();
        int ans = singleRowKeyboard.calculateTime(keyboard, word);
        System.out.println(ans);
    }
}
