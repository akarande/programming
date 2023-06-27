package grind75;

public class BinarySearch {

    public int binarySearch(int a[], int n) {
        int left = 0, right = a.length - 1;
        boolean found = false;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == n) {
                ans = mid;
                found = true;
                break;
            } else if (a[mid] <= n) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        if (found) return ans;
        return ans + 1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] a = {10, 56, 77, 190, 564, 777, 919};
        int val = 564;
        int ans = bs.binarySearch(a, val);
        System.out.println("ans = " + ans);
    }
}
