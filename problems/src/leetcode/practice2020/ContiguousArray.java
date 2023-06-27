package leetcode.practice2020;

/**
 * @author akarande
 **/
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int maxLen = Integer.MIN_VALUE;
        int zeros = 0, ones = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;
            else ones++;
            if(zeros == ones) {
                maxLen = Math.max(maxLen, zeros + ones);
            }
        }
        zeros = 0; ones = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 0) zeros++;
            else ones++;
            if(zeros == ones) {
                maxLen = Math.max(maxLen, zeros + ones);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        ContiguousArray contiguousArray = new ContiguousArray();
        int a[] = {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1};
        System.out.println("a.length = " + a.length);
        int maxLength = contiguousArray.findMaxLength(a);
        System.out.println("maxLength = " + maxLength);
    }
}
