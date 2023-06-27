package dynamicprogramming;

import java.util.Arrays;

/**
 * @author akarande
 * Reference: https://www.youtube.com/watch?v=YJJGdxI-B58
 **/
public class TreeAncestor {
    int[][] memo;
    int levels;
    public TreeAncestor(int n, int[] parent) {
        levels = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
        memo = new int[levels + 1][n];
        // initially set all values to -1
        for(int i = 0; i < memo.length; i++) Arrays.fill(memo[i], -1);

       //for each node starting from 1, upto n we find parent at each level starting from level 2.
        for(int i = 1; i < n; i++) {
            // Since we already have level 0 and 1, we should start with level 2.
            // Assign parent[i] for level 1.
            memo[0][i] = parent[i];
            for(int j = 1; j <= levels; j++) {
                memo[j][i] = memo[j - 1][memo[j - 1][i]];
                if (memo[j][i] == -1) break;
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for(int j = 0; j <= levels; j++) {
            if(((1 << j) & k) > 0) {
                node = memo[j][node];
                if(node == -1) break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int n = 7;
        int a[] = {-1,0,0,1,1,2,2};
        TreeAncestor treeAncestor = new TreeAncestor(n, a);
        System.out.println("treeAncestor (3, 1) = " + treeAncestor.getKthAncestor(3, 1));
        System.out.println("treeAncestor (5, 2) = " + treeAncestor.getKthAncestor(5, 2));
        System.out.println("treeAncestor (6, 3) = " + treeAncestor.getKthAncestor(6, 3));

    }
}
