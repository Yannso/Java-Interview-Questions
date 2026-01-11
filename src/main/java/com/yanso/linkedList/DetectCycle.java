package com.yanso.linkedList;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    /// 从 链表头 到 环入口 的距离为 a
                    /// 从 环入口 到 相遇点 的距离为 b
                    /// 从 相遇点 回到 环入口 的距离为 c
                    /// 从链表头出发到入口的距离 a，等于从相遇点出发绕 n-1 圈环后再走距离 c
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
