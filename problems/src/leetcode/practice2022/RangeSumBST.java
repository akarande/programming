package leetcode.practice2022;

import java.math.BigInteger;

public class RangeSumBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        solve(root, low, high, sum);
        return sum;
    }

    void solve(TreeNode root, int low, int high, int sum) {
        if (root == null) return;
        solve(root.left, low, high, sum);
        if (root.val >= low && root.val <= high) sum += root.val;
        solve(root.right, low, high, sum);
    }

    public static void main(String[] args) {
        String input = "some input string";
        int hash = 7;
        for (int i = 0; i < input.length(); i++) {
            hash = hash*31 + input.charAt(i);
        }
        byte[] bytes = input.getBytes();
        String res = new BigInteger(1, bytes).toString(16);
        System.out.println("hash = " + res);
//        String input = "some input string";
//        int hashCode = input.hashCode();
//        System.out.println("input hash code = " + hashCode);
        System.exit(0);
        RangeSumBST sumBST = new RangeSumBST();
        TreeNode root = sumBST.new TreeNode(10);
        root.left = sumBST.new TreeNode(5);
        root.left.left = sumBST.new TreeNode(3);
        root.left.right = sumBST.new TreeNode(7);
        root.right = sumBST.new TreeNode(15);
        root.right.right = sumBST.new TreeNode(18);
        int ans = sumBST.rangeSumBST(root, 7, 15);
        System.out.println("ans = " + ans);
    }
    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode() {}
    }
}
