package leetcode.practice2020;

import java.util.Arrays;

/**
 * @author akarande
 **/
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] <= b[0] && a[1] <= b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        //int dp[] = new int[envelopes.length];
        int count = 0;
        for(int i = 1; i < envelopes.length; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    count++;
                    break;
                }
            }
        }
        return count;
        //int max = 0;
        //for(int i = 0; i < dp.length; i++) max = Math.max(max, dp[i]);
        //return max;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        int arr[][] = {{5,4},{6,4},{6,7},{2,3}};
        int ans = russianDollEnvelopes.maxEnvelopes(arr);
        System.out.println("ans = " + ans);
    }

}
