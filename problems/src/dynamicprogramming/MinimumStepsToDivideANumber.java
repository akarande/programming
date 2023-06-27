package dynamicprogramming;

import java.util.Arrays;

/**
 * @author akarande
 **/
public class MinimumStepsToDivideANumber {
    private int[] arr;
    public int getMinSteps(int n) {
        arr = new int[n + 1];
        //return solve(n);
        return solveIterative(n);
    }

    int solve(int n) {
        if(n == 1) return 0;
        if(arr[n] > 0) return arr[n];
        int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE, s3 = Integer.MAX_VALUE;
        if (n % 3 == 0) s1 = solve(n / 3);
        if (n % 2 == 0) s2 = solve(n / 2);
        s3 = solve(n - 1);
        arr[n] = 1 + Math.min(s1, Math.min(s2, s3));
        return arr[n];
    }

    int solveIterative(int n) {
        Arrays.fill(arr, n + 1);
        arr[1] = 0;
        for(int i = 1; i < n; i++) {
            arr[i + 1] = Math.min(arr[i] + 1, arr[i + 1]);
            if(i * 2 <= n) {
                arr[i * 2] = Math.min(arr[i] + 1, arr[i * 2]);
            }
            if(i * 3 <= n) {
                arr[i * 3] = Math.min(arr[i] + 1, arr[i * 3]);
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
       /* MinimumStepsToDivideANumber divideANumber = new MinimumStepsToDivideANumber();
        int n = 1000000;
        int ans = divideANumber.getMinSteps(n);
        System.out.println("ans = " + ans);*/
        System.out.println("Math.pow((-2), 3) = " + Math.pow((-2), 3));
    }
}
