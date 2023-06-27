package july2022;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class CountIslands {

    public int countIslands(int[][] adj) {
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                if (!visited.contains(i + "," + j)) {
                    dfs(i, j, visited, adj);
                    count++;
                }
            }
            return count;
        }
        return 0;
    }

    void dfs(int i, int j, Set<String> visited, int[][] adj) {
        if (i < 0 || i >= adj.length || j < 0 || j >= adj[i].length || visited.contains(i + "," + j)) return;
        visited.add(i + "," + j);
        if (adj[i][j] == 1) {
            dfs(i + 1, j, visited, adj);
            dfs(i, j + 1, visited, adj);
            dfs(i - 1, j, visited, adj);
            dfs(i, j - 1, visited, adj);
        }
    }

    public static void main(String[] args) {
        int [][] a = {{0, 1, 0, 0, 1, 0},
                      {1, 1, 0, 0, 1, 0},
                      {0, 1, 0, 0, 0, 0},
                      {0, 0, 0, 1, 1, 0},
                      {0, 1, 0, 1, 1, 0},
                      {0, 0, 0, 0, 0, 0},
        };
        CountIslands islands = new CountIslands();
        int res = islands.countIslands(a);
        System.out.println("Number of Islands = " + res);
    }
}
