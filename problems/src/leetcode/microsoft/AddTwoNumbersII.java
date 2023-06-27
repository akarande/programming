package leetcode.microsoft;

import java.util.List;

public class AddTwoNumbersII {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode result = new ListNode(-1);
        ListNode ans = result;
        int sum = 0, carry = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            result.next = temp;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;
            result = result.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            result.next = new ListNode(carry);
            result = result.next;
        }
        return reverse(ans.next);
    }

    ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    ListNode addToList(int a[]) {
        ListNode curr = new ListNode(-1), head = curr;
        int i = 0;
        while (i < a.length) {
            curr.next = new ListNode(a[i++]);
            curr = curr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        int a[] = {9, 1, 6};
        int b[] = {0};
        ListNode listNode = addTwoNumbersII.addTwoNumbers(addTwoNumbersII.addToList(a), addTwoNumbersII.addToList(b));
        while (listNode != null) {
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }
    }
}
