package com.yanso.linkedList;

public class ListNode {
    /**
     * 链表结点类
     */
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


