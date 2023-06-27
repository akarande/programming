package leetcode.google.linkedlists;

import java.util.List;

/**
 * @author akarande
 **/
public class AddTwoLists {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int v) { val = v; }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 != null) {
            int curr = l1.val + l2.val;
            res.val += curr;
            res.next = new ListNode(res.val / 10);
            res.val %= 10;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            res.val += l1.val;
            res.next = new ListNode(res.val / 10);
            res.val %= 10;
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            res.val += l2.val;
            res.next = new ListNode(res.val / 10);
            res.val %= 10;
            res = res.next;
            l2 = l2.next;
        }
        if (res.val > 9) {
            res.next = new ListNode(res.val / 10);
            res.val %= 10;
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoLists addTwoLists = new AddTwoLists();
        ListNode n1 = addTwoLists.new ListNode(2);
        n1.next = addTwoLists.new ListNode(4);
        n1.next.next = addTwoLists.new ListNode(3);
        ListNode n2 = addTwoLists.new ListNode(5);
        n2.next = addTwoLists.new ListNode(6);
        n2.next.next = addTwoLists.new ListNode(4);
        ListNode listNode = addTwoLists.addTwoNumbers(n1, n2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
