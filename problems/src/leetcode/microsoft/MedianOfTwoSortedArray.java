package leetcode.microsoft;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return solve(nums1, nums2);
    }

    public double solve(int[] a, int[] b) {
        if(a == null || a.length == 0) {
            if(b != null && b.length > 0) {
                if(b.length % 2 == 0) {
                    return (b[b.length / 2] + b[b.length / 2 - 1]) / 2.0;
                } else {
                    return b[b.length / 2];
                }
            }
        }

        if(b == null || b.length == 0) {
            if(a != null && a.length > 0) {
                if(a.length % 2 == 0) {
                    return (a[a.length /2] + a[a.length / 2 - 1]) / 2.0;
                } else {
                    return a[a.length / 2];
                }
            }
        }
        if(a.length > b.length) {
            return solve(b, a);
        }
        int n1 = a.length, n2 = b.length;
        int high = n1, low = 0;
        while(low <= high) {

            int midA = (high + low) / 2;
            int midB = (n1 + n2 + 1) / 2 - midA;
            int maxLeftA = (midA == 0) ? Integer.MIN_VALUE : a[midA-1];
            int minRightA = (midA == a.length) ? Integer.MAX_VALUE : a[midA];

            int maxLeftB = (midB == 0) ? Integer.MIN_VALUE : b[midB-1];
            int minRightB = (midB == b.length) ? Integer.MAX_VALUE : b[midB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = midA - 1;
            } else {
                low = midA + 1;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        MedianOfTwoSortedArray twoSortedArray = new MedianOfTwoSortedArray();
        int a[] = {1,2,3,5,6};
        int b[] = {4};
        double medianSortedArrays = twoSortedArray.findMedianSortedArrays(a, b);
        System.out.println("medianSortedArrays = " + medianSortedArrays);
    }
}
