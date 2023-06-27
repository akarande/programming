package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionFind {

    int g[][];
    List<List<Integer>> g2;
    boolean vis[];
    public void addConnection(int i, int j) {
        g[i][j] = 1;
        g[j][i] = 1;
        g2.get(i).add(j);
        g2.get(j).add(i);
    }

    public boolean isConnected(int i, int j) {
        vis = new boolean[g.length];
        //return dfs(i, j);
        return dfs2(i, j);
    }

    boolean dfs(int i, int j) {
        if (g[i][j] == 1) return true;
        if (vis[i]) return false;
        vis[i] = true;
        for(int k = 0; k < g.length; k++) {
            if (g[i][k] == 1 && dfs(k, j)) return true;
        }
        return false;
    }

    boolean dfs2(int i, int j) {
        if (g2.contains(j)) return true;
        if (vis[i]) return false;
        vis[i] = true;
        for (Integer x : g2.get(i)) {
            if (dfs2(x, j)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int n = 5;
        UnionFind uf = new UnionFind();
        uf.g = new int[n][n];
        uf.g2 = new ArrayList<>();
        uf.g2.add(new ArrayList<>(Arrays.asList(1, 3)));
        uf.g2.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        uf.g2.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        uf.g2.add(new ArrayList<>(Arrays.asList(0, 1, 3)));

    }
}
