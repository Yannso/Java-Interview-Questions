package com.yanso.linkedList;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            ListNode temp = q.next;
            q.next = p;
            p.next = temp;
            prev.next = q;
            prev = p;
            p = temp;
            q = p == null ? null : p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createNode(5);
        ListNode newHead = new SwapPairs().swapPairs(head);
        LinkedListUtils.printLinkedList(newHead);
    }
}
