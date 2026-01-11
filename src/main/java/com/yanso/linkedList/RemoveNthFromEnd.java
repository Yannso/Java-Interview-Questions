package com.yanso.linkedList;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createNode(2);
        int n = 2;
        ListNode result = new RemoveNthFromEnd().removeNthFromEnd(head, n);
        LinkedListUtils.printLinkedList(result);
    }
}
