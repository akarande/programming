package leetcode.practice2021;

/**
 * @author akarande
 * Problem statement:
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
 **/

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        double root = Math.floor(Math.sqrt(n) * Math.sqrt(2));
        if ((int)((root * root + root)/2) > n) return (int)root - 1;
        return (int)root;
    }

    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        int ans = arrangingCoins.arrangeCoins(1804289383);
        System.out.println("ans = " + ans);
    }

}
