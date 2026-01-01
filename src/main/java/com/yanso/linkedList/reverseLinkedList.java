package com.yanso.linkedList;

import static com.yanso.linkedList.LinkedListUtils.*;

public class reverseLinkedList {
    public static void main(String[] args) {
        int N = 10;
        ListNode head = createRandomNode(N);

        printLinkedList(head);

        ListNode reversedHead  = reverse(head);
        printLinkedList(reversedHead);

        ListNode reversedHead_recursive = reverseRecursive(reversedHead);
        printLinkedList(reversedHead_recursive);
    }

    private static ListNode reverseRecursive(ListNode head) {
        /**
         * @param head 链表头结点
         * @return 反转后的链表头结点
         * 递归实现
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        // 原head的next节点，反转过后，成为子链表的最后一个结点，要指向head
        head.next.next = head; 
        head.next = null;
        return newHead;
    }

    public static ListNode reverse(ListNode head) {
        /**
         * @param head 链表头结点
         * @return 反转后的链表头结点
         * 迭代实现
         */
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}