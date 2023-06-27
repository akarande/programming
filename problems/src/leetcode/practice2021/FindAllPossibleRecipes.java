package leetcode.practice2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author akarande
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 **/
public class FindAllPossibleRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> adj = new HashMap<>();
        // Create the adjacency matrix
        for (int i = 0; i < recipes.length; i++) {
            Set<String> set = adj.getOrDefault(recipes[i], new HashSet<>());
            for (String ingridient : ingredients.get(i)) {
                set.add(ingridient);
            }
            adj.put(recipes[i], set);
        }
        // Now apply DFS
        Set<String> seen = new HashSet<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < recipes.length; i++) {
            dfs(recipes[i], seen, adj, stack);
        }
        List<String> result = new ArrayList<>();
        while(!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    void dfs(String curr, Set<String> seen, Map<String, Set<String>> adj, Stack<String> stack) {
        if (seen.contains(curr)) return;
        seen.add(curr);
        for (String neighbors : adj.getOrDefault(curr, new HashSet<>())) {
            dfs(neighbors, seen, adj, stack);
        }
        stack.add(curr);
    }

    public static void main(String[] args) {
        FindAllPossibleRecipes allPossibleRecipes = new FindAllPossibleRecipes();
        String[] recipes = {"bread","sandwich"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        ingredients.add(Arrays.asList("bread","meat"));
        String[] supplies = {"yeast","flour","meat"};
        List<String> allRecipes = allPossibleRecipes.findAllRecipes(recipes, ingredients, supplies);
        allRecipes.stream().forEach(recipe -> System.out.print(recipe + " "));
        System.out.println();
    }
}
