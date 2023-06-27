package leetcode.google.others;

/**
 * @author akarande
 **/
public class RangeSumQuery {
    int [] tree;
    int[] nums;
    public RangeSumQuery(int[] n) {
        nums = n;
        tree = new int[nums.length];
    }

    public void update (int index) {

    }

    public int sumRegion(int pos, int begin, int end, int startIdx, int endIdx) {
        if (startIdx <= begin && endIdx >= end) return tree[pos];

        return 0;
    }

    int buildTree(int i, int left, int right) {
        if (left == right) {
            tree[i] = nums[left];
            return nums[left];
        }
        int mid = (left + right) / 2;
        tree[i] = buildTree((2 * i) + 1, left, mid) + buildTree((2 * i) + 2, mid + 1, right);
        return tree[i];
    }

}
