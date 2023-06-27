package leetcode.microsoft;

import leetcode.practice2022.FindMinimumInSortedArray;

public class FindMinimumInSortedArrayII {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[high]) high = mid;
            else if (nums[mid] > nums[high]) low = mid + 1;
            else high -= 1;
        }
        return nums[low];
    }

    public static void main(String[] args) {
        FindMinimumInSortedArrayII sortedArrayII = new FindMinimumInSortedArrayII();
        int a[][] = {{0,1,4,4,5,6,7}, {1,3,5}, {2,2,2,0,1}, {4,5,6,7,0,1,4}};
        //int[][] a = {{7,0,1,4,5,6,7}};
        for (int i = 0; i < a.length; i++) {
            int min = sortedArrayII.findMin(a[i]);
            System.out.println("min = " + min);
        }

    }
}
