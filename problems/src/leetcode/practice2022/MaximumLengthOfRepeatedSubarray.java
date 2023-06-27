package leetcode.practice2022;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int a[][] = new int[m + 1][n + 1];
        int result = 0;
        for (int j = 1; j <= m; j++) {
            for (int k = 1; k <= n; k++) {
                if (nums1[j - 1] == nums2[k - 1]) a[j][k] = a[j - 1][k - 1] + 1;
                result = Math.max(result, a[j][k]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a1[] = {1,2,3,2,1}, a2[] = {3,2,1,4,7};
        MaximumLengthOfRepeatedSubarray repeatedSubarray = new MaximumLengthOfRepeatedSubarray();
        int length = repeatedSubarray.findLength(a1, a2);
        System.out.println(length);
    }
}
