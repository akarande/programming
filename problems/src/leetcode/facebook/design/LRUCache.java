package leetcode.facebook.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node tail, front;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.tail = new Node(0, 0);
        this.front = new Node(0, 0);
        this.tail.next = front;
        this.front.prev = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            remove(currNode);
            insert(currNode);
            return currNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            remove(currNode);
        }
        map.put(key, new Node(key, value));
        insert(map.get(key));
        if (map.size() > capacity) {
            Node leastRecentNode = tail.next;
            remove(leastRecentNode);
            map.remove(leastRecentNode.key);
        }
    }


    private void insert(Node node) {
        Node prevNode = front.prev;
        Node nextNode = front;
        prevNode.next = nextNode.prev = node;
        node.next = nextNode;
        node.prev = prevNode;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    class Node {
        int key, value;
        Node prev, next;
        public  Node(int k, int v) {
            this.key = k;
            this.value = v;
            prev = next = null;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println("lruCache.get(1) = " + lruCache.get(1));
        lruCache.put(3,3);
        System.out.println("lruCache.get(2) = " + lruCache.get(2));
        lruCache.put(4,4);
        System.out.println("lruCache.get(1) = " + lruCache.get(1));
        System.out.println("lruCache.get(3) = " + lruCache.get(3));
        System.out.println("lruCache.get(4) = " + lruCache.get(4));
    }
}
