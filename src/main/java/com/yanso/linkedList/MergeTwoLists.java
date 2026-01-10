package com.yanso.linkedList;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode q = list1;
        ListNode r = list2;
        while (q != null && r != null) {
            if (q.val < r.val) {
                p.next = q;
                q = q.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = q == null ? r : q;
        return head.next;
    }
}
