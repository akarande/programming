package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import static java.util.Collections.singleton;

/**
 * @author akarande
 **/
public class BraceExpansionII {

    public List<String> braceExpansion(String expression) {
        Stack<Set<String>> productStack = new Stack<>();
        Stack<Set<String>> unionStack = new Stack();
        productStack.push(new HashSet<>(singleton("")));
        unionStack.push(new HashSet<>());
        for(char curr : expression.toCharArray()) {
            if(curr == '{') {
                productStack.push(new HashSet<>(singleton("")));
                unionStack.push(new HashSet<>());
            } else if (curr == '}') {
                unionStack.push(union(unionStack.pop(), productStack.pop()));
                productStack.push(cartersianProduct(productStack.pop(), unionStack.pop()));
            } else if(curr == ',') {
                unionStack.push(union(unionStack.pop(), productStack.pop()));
                productStack.push(new HashSet<>(singleton("")));
            } else {
                productStack.push(cartersianProduct(productStack.pop(), new HashSet<>(singleton("" + curr))));
            }
        }
        List<String> result = new ArrayList<>(productStack.pop());
        Collections.sort(result);
        return result;
    }

    private Set<String> union(Set<String> setA, Set<String> setB) {
        Set<String> union = new HashSet<>();
        //for(String b : setB) union.add(b);
        union.addAll(setA);
        union.addAll(setB);
        return union;
    }

    private Set<String> cartersianProduct(Set<String> setA, Set<String> setB) {
        Set<String> product = new HashSet<>();
        for(String a : setA) {
            for(String b : setB) {
                product.add(a + b);
            }
        }
        return product;
    }

    public static void main(String[] args) {
        BraceExpansionII expansionII = new BraceExpansionII();
        String expr = "{a,b}{c,{de}}";
        System.out.println("expr = " + expansionII.braceExpansion(expr));
    }
}
