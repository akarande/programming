package leetcode.practice2020;

import java.util.Arrays;

/**
 * @author akarande
 **/
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        for(int i = 0; i < n; i++) nums[i] += nums[n + i] * 10000;
        for(int i = n - 1; i >= 0; i--) {
            nums[2 * i + 1] = nums[i] / 10000;
            nums[2 * i] = nums[i] % 10000;
        }
        return nums;
    }

    public static void main(String[] args) {
        int a[]= {2,5,1,3,4,7};
        ShuffleTheArray array = new ShuffleTheArray();
        int[] shuffled = array.shuffle(a, a.length / 2);
        System.out.println("Arrays.toString(shuffled) = " + Arrays.toString(shuffled));
    }
}
