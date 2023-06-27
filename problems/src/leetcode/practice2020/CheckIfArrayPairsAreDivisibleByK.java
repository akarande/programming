package leetcode.practice2020;

import java.util.Arrays;

/**
 * @author akarande
 **/
public class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        int sum = Arrays.stream(arr).sum();
        if(sum % k != 0) return false;
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while(i < j) {
            if((arr[i++] + arr[j++]) % k != 0) return false;
        }
        return true;
    }
}
