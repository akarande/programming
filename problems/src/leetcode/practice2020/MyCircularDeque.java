package leetcode.practice2020;

/**
 * @author akarande
 **/
public class MyCircularDeque {

    class MyQueue {
        int value;
        MyQueue prev, next;
        public MyQueue(int value) {
            this.value = value;
            prev = null;
            next = null;
        }
    }

    int size = 0, capacity = 0;
    MyQueue head = null, tail = null;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        head = null;
        tail = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(!isFull()) {
            MyQueue myQueue = new MyQueue(value);
            if(head == null && tail == null) {
                head = myQueue;
                tail = head;
            } else {
                head.prev = myQueue;
                myQueue.next = head;
                head = myQueue;
            }
            size++;
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(!isFull()) {
            MyQueue myQueue = new MyQueue(value);
            if(head == null && tail == null) {
                head = myQueue;
                tail = head;
            } else {
                tail.next = myQueue;
                myQueue.prev = tail;
                tail = myQueue;
            }
            size++;
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(!isEmpty()) {
            head = head.next;
            if(head != null) head.prev = null;
            size--;
            if(size == 0) {
                head = null;
                tail = null;
            }
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(!isEmpty()) {
            tail = tail.prev;
            if(tail != null) tail.next = null;
            size--;
            if(size == 0) {
                head = null;
                tail = null;
            }
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return head.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        return tail.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        int k = 4;
        MyCircularDeque myCircularDeque = new MyCircularDeque(k);
        /**
         * ["leetcode.practice2020.MyCircularDeque","insertFront","deleteLast","getRear","getFront","getFront","deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
         * [[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
         */
        System.out.println("myCircularDeque.insertFront(4) = " + myCircularDeque.insertFront(9));
        System.out.println("myCircularDeque.deleteLast() = " + myCircularDeque.deleteLast());
        System.out.println("myCircularDeque.getRear() = " + myCircularDeque.getRear());
        System.out.println("myCircularDeque.getFront() = " + myCircularDeque.getFront());
        System.out.println("myCircularDeque.getFront() = " + myCircularDeque.getFront());
        System.out.println("myCircularDeque.deleteFront() = " + myCircularDeque.deleteFront());
        System.out.println("myCircularDeque.insertFront(6) = " + myCircularDeque.insertFront(6));
        System.out.println("myCircularDeque.insertLast(5) = " + myCircularDeque.insertLast(5));
        System.out.println("myCircularDeque.insertFront(9) = " + myCircularDeque.insertFront(9));
        System.out.println("myCircularDeque.getFront() = " + myCircularDeque.getFront());
        System.out.println("myCircularDeque.insertFront(6) = " + myCircularDeque.insertFront(6));
        /*System.out.println("insertFront = " + myCircularDeque.insertFront(5));
        System.out.println("getFront() = " + myCircularDeque.getFront());
        System.out.println("isEmpty() = " + myCircularDeque.isEmpty());
        System.out.println("myCircularDeque.deleteFront() = " + myCircularDeque.deleteFront());
        System.out.println("myCircularDeque.insertLast(3) = " + myCircularDeque.insertLast(3));
        System.out.println("myCircularDeque.getRear() = " + myCircularDeque.getRear());
        System.out.println("myCircularDeque.insertLast(7) = " + myCircularDeque.insertLast(7));
        System.out.println("myCircularDeque.insertFront(7) = " + myCircularDeque.insertFront(7));
        System.out.println("myCircularDeque.deleteLast() = " + myCircularDeque.deleteLast());
        System.out.println("myCircularDeque.insertLast(4) = " + myCircularDeque.insertLast(4));
        System.out.println("myCircularDeque.isEmpty() = " + myCircularDeque.isEmpty());*/
        /**
         * ["leetcode.practice2020.MyCircularDeque","insertFront","getFront","isEmpty","deleteFront","insertLast","getRear","insertLast","insertFront","deleteLast","insertLast","isEmpty"]
         * [[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
         */
    }
}
