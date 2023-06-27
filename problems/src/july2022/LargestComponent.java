package july2022;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author akarande
 **/
public class LargestComponent {
    Map<Integer, List<Integer>> map;

    int dfs(int node, Set<Integer> visited) {
        if (visited.contains(node)) return 0;
        visited.add(node);
        int sum = 1;
        for (int n : map.getOrDefault(node, new ArrayList<>())) {
            sum += dfs(n, visited);
        }
        return sum;
    }

    public static void main(String[] args) {
        LargestComponent component = new LargestComponent();
        component.map = new HashMap<>();
        component.map.put(0, Arrays.asList(1, 5, 8));
        component.map.put(1, Arrays.asList(0));
        component.map.put(2, Arrays.asList(3, 4));
        component.map.put(3, Arrays.asList(2, 4));
        component.map.put(4, Arrays.asList(3, 2));
        component.map.put(5, Arrays.asList(0, 8));
        component.map.put(2, Arrays.asList(0, 5));
        int maxComp = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<>();
        for (int key : component.map.keySet()) {
            if (visited.contains(key)) continue;
            maxComp = Math.max(maxComp, component.dfs(key, visited));
        }
        System.out.println("maxComp = " + maxComp);
    }
}
