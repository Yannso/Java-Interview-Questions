package com.yanso.linkedList;

public class CopyRandomList {
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        // 1. 在每个原节点后面创建一个克隆节点
        RandomNode cur = head;
        while (cur != null) {
            RandomNode clone = new RandomNode(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 2. 赋值 random 指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 3. 拆分链表
        RandomNode dummy = new RandomNode(0);
        RandomNode p = dummy;
        cur = head;
        while (cur != null) {
            p.next = cur.next;
            cur.next = cur.next.next;
            p = p.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
