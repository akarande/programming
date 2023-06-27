package leetcode.practice2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) return 0;
        if (sticks.length < 3) return Arrays.stream(sticks).sum();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int stick : sticks) queue.offer(stick);
        int value1 = 0, value2 = 0, total = 0;
        while (!queue.isEmpty()) {
            value1 = queue.poll();
            if (!queue.isEmpty()) {
                value2 = queue.poll();
                total += value1 + value2;
                queue.offer(value1 + value2);
            } else break;
        }
        return total;
    }

    public static void main(String[] args) {
        MinimumCostToConnectSticks sticks = new MinimumCostToConnectSticks();
        int a[] = {1,8,3,5};
        int ans = sticks.connectSticks(a);
        System.out.println("ans = " + ans);
    }
}
