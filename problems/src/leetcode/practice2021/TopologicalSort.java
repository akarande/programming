package leetcode.practice2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author akarande
 **/
public class TopologicalSort {

    private int graph[][] = {{0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 1, 0, 0},
                     {0, 1, 0, 0, 0, 0},
                     {1, 1, 0, 0, 0, 0},
                     {1, 0, 1, 0, 0, 0}};

    public List<Integer> topologicalSort(int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean [graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfs(i, visited, stack);
        }
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    public void dfs(int i, boolean[] visited, Stack<Integer> stack) {
        if (visited[i]) return;
        visited[i] = true;
        for (int k : graph[i]) {
            dfs(k, visited, stack);
        }
        stack.add(i);
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> res = topologicalSort.topologicalSort(topologicalSort.graph);
        res.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();

        int adj[][] = {{}, {}, {3}, {1}, {0, 1}, {0, 2}};
        res = topologicalSort.topologicalSort(adj);
        res.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
