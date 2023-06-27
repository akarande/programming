package leetcode.practice2020;

/**
 * @author akarande
 **/
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int sumLeft[] = new int[n];
        int sumRight[] = new int[n];
        sumLeft[0] = nums[0];
        for(int i = 1; i < nums.length; i++) sumLeft[i] = sumLeft[i - 1] + nums[i];

        sumRight[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) sumRight[i] = sumRight[i + 1] + nums[i];

        for(int i = 0; i < n; i++) {
            if(sumLeft[i] == sumRight[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int a[] = {1,7,3,6,5,6};
        int index = findPivotIndex.pivotIndex(a);
        System.out.println("index = " + index);
    }
}
