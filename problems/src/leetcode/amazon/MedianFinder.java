package leetcode.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> smallHeap, largeHeap;

    public MedianFinder() {
        largeHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        smallHeap.add(num);
        if (!smallHeap.isEmpty() && !largeHeap.isEmpty()
                && smallHeap.peek() > largeHeap.peek()) largeHeap.add(smallHeap.poll());
        if (smallHeap.size() > largeHeap.size() + 1) largeHeap.add(smallHeap.poll());
        if (largeHeap.size() > smallHeap.size() + 1) smallHeap.add(largeHeap.poll());
    }

    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) return (double)smallHeap.peek();
        else if (largeHeap.size() > smallHeap.size()) return (double)largeHeap.peek();
        return 0.5 * (smallHeap.peek() + largeHeap.peek());

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(1);
        double median = medianFinder.findMedian();
        System.out.println("median = " + median);
        medianFinder.addNum(3);
        median = medianFinder.findMedian();
        System.out.println("median = " + median);
    }
}
