package leetcode.practice2022;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
    int sum, size;
    Queue<Integer> queue;
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        sum = 0;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() > size) {
            int remove = queue.poll();
            sum -= remove;

        }
        return (1.* sum) / queue.size();
    }

    public static void main(String[] args) {
        MovingAverageFromDataStream dataStream = new MovingAverageFromDataStream(3);
        int a[] = {1, 10, 3, 5};
        for (int i = 0; i < a.length; i++) System.out.print(dataStream.next(a[i]) + " ");
    }
}
