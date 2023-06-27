package leetcode.premium.algo100;

public class ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {
        double currDiff = 1000000005.0;
        return solve(root, target, currDiff, root.val);
    }

    int solve(TreeNode root, double target, double currDiff, int val) {
        if (root != null) {
            if (currDiff > Math.abs(root.val - target)) {
                currDiff = Math.abs(root.val - target);
                val = root.val;
            }
            int r1 = solve(root.left, target, currDiff, val);
            int r2 = solve(root.right, target, currDiff, val);
            if (Double.compare(Math.abs(r1 - target), Math.abs(r2 - target)) == 0) {
                val = Math.min(r1, r2);
            } else if (Double.compare(Math.abs(r1 - target), Math.abs(r2 - target)) > 0) {
                val = r1;
            } else {
                val = r2;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        ClosestBSTValue bstValue = new ClosestBSTValue();
        TreeNode nodeRoot = bstValue.new TreeNode(1);
        TreeNode nodeRight = bstValue.new TreeNode(2);
        double target = 3.714286;
        nodeRoot.right = nodeRight;
        int ans = bstValue.closestValue(nodeRoot, target);
        System.out.println("ans = " + ans);
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
}
