package leetcode.practice2020;

/**
 * @author akarande
 **/
public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    if(solve(i, j, grid)) count++;
                }
            }
        }
        return count;
    }

    boolean solve(int i, int j, int[][] g) {
        for(int row = 0; row < g.length; row++) {
            if(i != row && g[row][j] == 1) return true;
        }
        for(int col = 0; col < g[0].length; col++) {
            if(j != col && g[i][col] == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CountServersThatCommunicate countServersThatCommunicate = new CountServersThatCommunicate();
        int[][] g = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0},{0,0,1,0,0,1,0,0}};
        int ans = countServersThatCommunicate.countServers(g);
        System.out.println("ans = " + ans);
    }
}
