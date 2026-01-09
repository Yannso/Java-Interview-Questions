package com.yanso.linkedList;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // 增加空判断，保证代码健壮
        if (head == null || head.next == null) return true;

        // 1. 寻找前半部分的尾节点 (slow)
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 反转后半部分链表
        // prev 会成为反转后新链表的头节点
        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // 3. 左右两边对比
        ListNode leftPtr = head;
        ListNode rightPtr = prev;
        boolean isPalin = true; // 推荐先记录结果，而不是直接 return，方便后续做清理工作

        while (rightPtr != null) {
            if (leftPtr.val != rightPtr.val) {
                isPalin = false;
                break;
            }
            leftPtr = leftPtr.next;
            rightPtr = rightPtr.next;
        }

        return isPalin;
    }
}
