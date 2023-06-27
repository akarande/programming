package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author akarande
 **/
public class SortTheMatrixDiagonally {
    Set<String> visited;
    int[][] ans;
    public int[][] diagonalSort(int[][] mat) {
        ans = new int[mat.length][mat[0].length];
        visited = new HashSet<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(!isVisited(i, j)) {
                    solve(i, j, mat);
                }
            }
        }
        return ans;
    }

    void solve(int i, int j, int[][] m) {
        List<Integer> list = new ArrayList<>();
        int row = i, col = j;
        while(row < m.length && col < m[row].length) {
            list.add(m[row][col]);
            visited.add("" + row + "-" + col);
            row++;
            col++;
        }
        Collections.sort(list);
        row = i; col = j;
        int k = 0;
        while(row < m.length && col < m[row].length && k < list.size()) {
            ans[row][col] = list.get(k++);
            row++;
            col++;
        }
    }

    boolean isVisited(int i, int j) {
        return visited.contains("" + i + "-" + j);
    }

    public static void main(String[] args) {
        SortTheMatrixDiagonally matrixDiagonally = new SortTheMatrixDiagonally();
        int[][] m = {{3,3,1,1}, {2,2,1,2}, {1,1,1,2}};
        int[][] ans = matrixDiagonally.diagonalSort(m);
        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
