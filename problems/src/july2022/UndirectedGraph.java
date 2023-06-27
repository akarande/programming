package july2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akarande
 **/
public class UndirectedGraph {

    private Map<Character, List<Character>> adj;
    boolean[] visited;

    boolean dfs(char source, char dest) {
        if (source == dest) return true;
        if (visited[source - 'a']) return false;
        visited[source - 'a'] = true;
        for (char c : adj.getOrDefault(source, new ArrayList<>())) {
            if (!visited[c - 'a'] && dfs(c, dest)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.adj = new HashMap<>();
        graph.adj.put('i', Arrays.asList('j', 'k'));
        graph.adj.put('j', Arrays.asList('i'));
        graph.adj.put('k', Arrays.asList('i', 'm', 'l'));
        graph.adj.put('m', Arrays.asList('k'));
        graph.adj.put('l', Arrays.asList('k'));
        graph.adj.put('o', Arrays.asList('n'));
        graph.adj.put('n', Arrays.asList('o'));
        graph.visited = new boolean[26];
        boolean hasValidPath = graph.dfs('n', 'o');
        System.out.println("hasValidPath: " + hasValidPath);
    }
}
