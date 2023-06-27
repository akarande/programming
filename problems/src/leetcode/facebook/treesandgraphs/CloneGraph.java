package leetcode.facebook.treesandgraphs;

import java.util.*;

public class CloneGraph {

    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map = new HashMap<>();
        fillMap(node);
        for (Node key : map.keySet()) {
            Node newNode = map.get(key);
            for (Node orignialNode : key.neighbors) {
                newNode.neighbors.add(map.get(orignialNode));
            }
        }
        return map.get(node);
    }

    void fillMap(Node node) {
        if (map.containsKey(node)) return;
        if (!map.containsKey(node)) map.put(node, new Node(node.val));
        for (Node neighbor : node.neighbors) fillMap(neighbor);
    }

    public static void main(String[] args) {
        List<Node> list =  new ArrayList<>();
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = cloneGraph.new Node(1);
        Node node2 = cloneGraph.new Node(2);
        Node node3 = cloneGraph.new Node(3);
        Node node4 = cloneGraph.new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node node = cloneGraph.cloneGraph(node1);
        System.out.println("node = " + node.val);
        System.out.println("neighbors = " + Arrays.toString(node.neighbors.toArray()));
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
