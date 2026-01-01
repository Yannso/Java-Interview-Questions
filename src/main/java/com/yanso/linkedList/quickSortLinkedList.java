package com.yanso.linkedList;

public class quickSortLinkedList {
    public static ListNode quickSort(ListNode head) {
        // 如果链表为空或只有一个结点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pivot = head;
        ListNode current = head.next;

        //  创建哑节点用于构建两个子链表
        ListNode lessHead = new ListNode(-1); // 小于pivot的链表
        ListNode greaterHead = new ListNode(-1); // 大于等于pivot的链表

        ListNode lessTail = lessHead;
        ListNode greaterTail = greaterHead;

        while (current != null) {
            if (current.val < pivot.val) {
                lessTail.next = current;
                lessTail = lessTail.next;
            } else {
                greaterTail.next = current;
                greaterTail = greaterTail.next;
            }
            current = current.next;
        }

        // 切断链表尾部，防止形成环
        lessTail.next = null;
        greaterTail.next = null;

        pivot.next = null; // 切断pivot的next，防止环

        // 递归排序左右子链表
        ListNode sortedLess = quickSort(lessHead.next); 
        ListNode sortedGreater = quickSort(greaterHead.next);

        // 连接排序后的子链表和pivot
        return concatenate(sortedLess, pivot, sortedGreater);
    }

    private static ListNode concatenate(ListNode less, ListNode pivot, ListNode greater) {
        if (less == null) {
            pivot.next = greater;
            return pivot;
        }

        ListNode current = less;
        while (current.next != null) {
            current = current.next;
        }

        current.next = pivot; // 连接less子链表和pivot
        pivot.next = greater; // 连接greater子链表
        return less;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createRandomNode(100,-200,300);
        System.out.println("Original list:");
        LinkedListUtils.printLinkedList(head);

        ListNode newHead = quickSort(head);
        System.out.println("Sorted list:");
        LinkedListUtils.printLinkedList(newHead);
    }
}