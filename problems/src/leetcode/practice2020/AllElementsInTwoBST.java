package leetcode.practice2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author akarande
 * 1305. All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 **/
public class AllElementsInTwoBST {
    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int v) {
            this.val = v;
            left = right = null;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> sortedList = new ArrayList<>();
        solve(root1, root2, sortedList);
        return sortedList;
    }

    void solve(TreeNode r1, TreeNode r2, List<Integer> list) {
        if(r1 == null && r2 == null) return;
        // If leaf node, then add the smallest element first
        if(r1 != null && r2 != null && r1.left == null && r1.right == null
            && r2.left == null && r2.right == null) {
            if(r1.val <= r2.val)
                list.add(r1.val);
            else list.add(r2.val);
            return;
        }
        else if(r1 != null && r1.left != null) solve(r1.left, r2.left, list);
        else if(r1 != null && r1.right != null) solve(r1.right, r2.right, list);
        //else if(r2 != null && r2.left != null) solve(r1, r2.left, list);
        //else if(r2 != null && r2.left != null) solve(r1, r2.right, list);
    }
    List<Integer> ans = new ArrayList<>();
    List<Integer> inOrder(TreeNode root) {
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }

    void inOrderRec(TreeNode root) {
        if(root == null) return;
        inOrderRec(root.left);
        System.out.println("root.val = " + root.val);
        inOrderRec(root.right);
    }

    


    public static void main(String[] args) {
        AllElementsInTwoBST twoBST = new AllElementsInTwoBST();
        TreeNode t1 = twoBST.new TreeNode(2);
        t1.left = twoBST.new TreeNode(1);
        t1.right = twoBST.new TreeNode(4);
        
        TreeNode t2 = twoBST.new TreeNode(1);
        t2.left = twoBST.new TreeNode(0);
        t2.right = twoBST.new TreeNode(3);

        List<Integer> allElements = twoBST.inOrder(t1);//twoBST.getAllElements(t1, t2);
        System.out.println("allElements.toString() = " + allElements.toString());
        //twoBST.inOrderRec(t1);
    }
}
