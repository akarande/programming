package leetcode.practice2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author akarande
 **/
class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> map;
    int max;

    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
        max = 0;
    }

    public void push(int x) {
        int frequency = freq.getOrDefault(x, 0) + 1;
        freq.put(x, frequency);
        if(frequency > max) max = frequency;
        map.computeIfAbsent(frequency, stack -> new Stack()).push(x);
    }

    public int pop() {
        int ans = map.get(max).pop();
        freq.put(ans, freq.get(ans) - 1);
        if(map.get(max).isEmpty() || map.get(max).size() == 0) max--;
        return ans;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        int a[] = {5,7,5,7,4,5};
        for(int v : a) {
            freqStack.push(v);
        }
        for(int i = 0; i < 4; i++) {
            System.out.println("freqStack = " + freqStack.pop());
        }
    }
}