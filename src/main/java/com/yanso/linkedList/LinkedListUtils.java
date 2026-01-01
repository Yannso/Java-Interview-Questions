package com.yanso.linkedList;

import java.util.Random;

public class LinkedListUtils {
    static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    static ListNode createNode(int n) {
        /**
         * 创建一个包含1到n的链表
         * @param n: 链表结点个数
         * @return: 返回链表头结点
         */
        if (n <= 0) {
            return null;
        }
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= n; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return head;
    }
    
    static ListNode createRandomNode(int n) {
        /**
         * 创建一个包含n个随机数的链表，随机数范围为1到100
         * @param n: 链表结点个数
         * @return: 返回链表头结点
         */
        return createRandomNode(n, 1, 100);
    }

    static ListNode createRandomNode(int n, int MIN, int MAX) {
        /**
         * 创建一个包含n个随机数的链表
         * @param n: 链表结点个数
         * @param MIN: 随机数最小值
         * @param MAX: 随机数最大值
         * @return: 返回链表头结点
         */
        if (n <= 0) {
            return null;
        }
        Random rand = new Random();
        // nextInt(max - min + 1) + min 生成[min, max]范围内的随机数
        ListNode head = new ListNode(rand.nextInt(MAX - MIN + 1) + MIN);
        ListNode current = head;
        while (--n > 0) {
            current.next = new ListNode(rand.nextInt(MAX - MIN + 1) + MIN);
            current = current.next;
        }
        return head;
    }
}
