package leetcode.practice2020;

/**
 * @author akarande
 **/
public class MyCircularQueue {
    class MyQ {
        int value;
        MyQ prev, next;
        public MyQ(int v) {
            value = v;
            prev = null;
            next = null;
        }
    }

    int size = 0, capacity = 0;
    MyQ head = null, tail = null;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;
        head = null;
        tail = head;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()) {
            MyQ node = new MyQ(value);
            if(size == 0) {
                head = node;
                tail = head;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            size++;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()) {
            head = head.next;
            size--;
            if(size == 0) {
                tail = null;
                head = null;
            } else {
                head.prev = null;
            }
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return head.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        return tail.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        int k = 3;
        MyCircularQueue circularQueue = new MyCircularQueue(k);
        System.out.println("circularQueue.enQueue(1) = " + circularQueue.enQueue(1));
        System.out.println("circularQueue.enQueue(2) = " + circularQueue.enQueue(2));
        System.out.println("circularQueue.enQueue(3) = " + circularQueue.enQueue(3));
        System.out.println("circularQueue.enQueue(4) = " + circularQueue.enQueue(4));
        System.out.println("circularQueue.Rear() = " + circularQueue.Rear());
        System.out.println("circularQueue.isFull() = " + circularQueue.isFull());
        System.out.println("circularQueue.deQueue() = " + circularQueue.deQueue());
        System.out.println("circularQueue.enQueue(4) = " + circularQueue.enQueue(4));
        System.out.println("circularQueue.Rear() = " + circularQueue.Rear());
    }
}
