package com.yanso.linkedList;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextListNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextListNode;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.createNode(5);
        ListNode reverseList = new ReverseList().reverseList(list);
        LinkedListUtils.printLinkedList(reverseList);
    }
}
