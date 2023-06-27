package leetcode.practice2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author akarande
 **/
public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        int count1 = 0, count2 = 0;
        while (h1 != null) {
            h1 = h1.next;
            count1++;
        }
        while (h2 != null) {
            h2 = h2.next;
            count2++;
        }
        h1 = headA;
        h2 = headB;
        if (count1 > count2) {
            int temp = count1 - count2;
            while (temp > 0) {
                h1 = h1.next;
                temp--;
            }
        } else {
            int temp = count2 - count1;
            while (temp > 0) {
                h2 = h2.next;
                temp--;
            }
        }
        while (h1 != null && h2 != null) {
            if (h1 == h2) break;
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        LinkedListIntersection linkedListIntersection = new LinkedListIntersection();
        ListNode node1 = linkedListIntersection. new ListNode(4);
        ListNode node2 = linkedListIntersection. new ListNode(5);
        node1.next = linkedListIntersection.new ListNode(1);
        node2.next = linkedListIntersection.new ListNode(6);
        node2.next.next = linkedListIntersection.new ListNode(1);
        ListNode common = linkedListIntersection.new ListNode(8);
        node1.next.next = common;
        node2.next.next.next = common;
        common.next = linkedListIntersection. new ListNode(4);
        common.next.next = linkedListIntersection. new ListNode(5);
        ListNode intersectionNode = linkedListIntersection.getIntersectionNode(node1, node2);
        System.out.println("Intersection at " + intersectionNode.val);
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
            next = null;
        }
    }
}
