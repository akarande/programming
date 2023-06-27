package leetcode.practice2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author akarande
 **/
public class FrequencyStack {

    int max;
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> stackMap;
    public FrequencyStack() {
        max = 0;
        map = new HashMap<>();
        stackMap = new HashMap<>();
    }

    public void push(int x) {
        int currFrequency = map.getOrDefault(x, 0) + 1;
        map.put(x, currFrequency);
        max = Math.max(max, currFrequency);
        Stack<Integer> currStack = stackMap.getOrDefault(currFrequency, new Stack<>());
        currStack.push(x);
        stackMap.put(currFrequency, currStack);
    }

    public int pop() {
        int ans = stackMap.get(max).pop();
        map.put(ans, map.getOrDefault(ans, 0) - 1);
        if (stackMap.get(max).isEmpty() || stackMap.get(max).size() == 0) max--;
        return ans;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(5);
        frequencyStack.push(7);
        frequencyStack.push(5);
        frequencyStack.push(7);
        frequencyStack.push(4);
        frequencyStack.push(5);
        frequencyStack.pop();
        frequencyStack.pop();
        frequencyStack.pop();
        frequencyStack.pop();
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */