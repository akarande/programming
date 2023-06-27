package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author akarande
 **/
public class MaximumNumberOFBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] a = new int[26];
        for(char c : text.toCharArray()) a[c - 'a']++;
        int min = Integer.MAX_VALUE;
        char[] b = {'b', 'a', 'l', 'o', 'n'};
        for(int i = 0; i < b.length; i++) {
            if(b[i] == 'l' || b[i] == 'o') min = Math.min(min, a[b[i] - 'a']/2);
            else min = Math.min(min, a[b[i] - 'a']);
        }
        return min;
    }

    public static void main(String[] args) {
        /*leetcode.practice2020.MaximumNumberOFBalloons maximumNumberOFBalloons = new leetcode.practice2020.MaximumNumberOFBalloons();
        String text = "nlaebolko";
        int ans = maximumNumberOFBalloons.maxNumberOfBalloons(text);
        System.out.println("ans = " + ans);*/
        List<String> s = new ArrayList<>();
        s.add("Mumbai");
        s.add("Delhi");
        s.add("Pune");
        s.add("Bangalore");
        String[] strings = (String[]) s.stream().toArray();
        System.out.println("Arrays.stream(strings).toString() = " + Arrays.stream(strings).toString());
    }
}
