package leetcode.practice2022;

import java.util.Arrays;

public class FindMinimumInSortedArray {
    public int findMin(int[] a) {
        if (a.length == 1) return a[0];
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //if (mid == low) return a[low];
            if (a[low] < a[mid] && a[mid] < a[high]) {
                high = mid;
            } else if (a[low] > a[mid] && a[high] > a[mid]) {
                if (a[low] > a[high]) {
                    low = mid;
                } else {
                    high = mid;
                }
            } else if (a[low] < a[mid] && a[high] < a[mid]) {
                if (a[low] < a[high]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                low = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMinimumInSortedArray sortedArray = new FindMinimumInSortedArray();
        int a[][] = {{2,3,1}, {3,4,5,1,2}, {4,5,6,7,0,1,2}, {11,13,15,17}};
        for (int i = 0; i < a.length; i++) {
            int min = sortedArray.findMin(a[i]);
            System.out.print(Arrays.toString(a[i]) + "\t");
            System.out.print("min = " + min + "\n");
        }
    }
}
