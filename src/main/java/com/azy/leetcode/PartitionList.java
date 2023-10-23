package com.azy.leetcode;

/**
 * <p>2023-09-22 14:17:03</p>
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode h = head;
        for (int i = 10; i >= 0; i--) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode result = partition(h.next, 5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode p1 = head1;
        ListNode head2 = new ListNode();
        ListNode p2 = head2;
        while (head != null) {
            if (head.val < x) {
                p1.next = new ListNode(head.val);
                p1 = p1.next;
            }
            if (head.val >= x) {
                p2.next = new ListNode(head.val);
                p2 = p2.next;
            }
            head = head.next;
        }
        // p2.next = null;//必须有
        p1.next = head2.next;
        return head1.next;
    }

}
