package july2022;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author akarande
 **/
public class ConnectedComponents {

    boolean dfs(int node, Set<Integer> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);
        for (Integer n : adj.getOrDefault(node, new ArrayList<>())) dfs(n, visited);
        return true;
    }

    void bfs(int node, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                int curr = queue.poll();
                if (visited.contains(curr)) continue;
                visited.add(curr);
                for (int neighbor: adj.getOrDefault(curr, new ArrayList<>())) {
                    queue.offer(neighbor);
                }
             }
        }
    }
    Map<Integer, List<Integer>> adj;
    public static void main(String[] args) {
        ConnectedComponents connectedComponents = new ConnectedComponents();
        connectedComponents.adj = new HashMap<>();
        connectedComponents.adj.put(0, Arrays.asList(8, 1, 5));
        connectedComponents.adj.put(1, Arrays.asList(0));
        connectedComponents.adj.put(2, Arrays.asList(3, 4));
        connectedComponents.adj.put(3, Arrays.asList(2, 4));
        connectedComponents.adj.put(4, Arrays.asList(3, 2));
        connectedComponents.adj.put(5, Arrays.asList(0, 8));
        connectedComponents.adj.put(8, Arrays.asList(0, 5));
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer key : connectedComponents.adj.keySet()) {
            if (connectedComponents.dfs(key, visited)) count++;
        }
        System.out.println("connectedComponents using DFS = " + count);
        visited = new HashSet<>();
        count = 0;
        for (Integer key : connectedComponents.adj.keySet()) {
            if (visited.contains(key)) continue;
            connectedComponents.bfs(key, visited);
            count++;
        }
        System.out.println("connectedComponents using BFS = " + count);
    }
}
