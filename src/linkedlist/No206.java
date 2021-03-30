package linkedlist;

import datastructure.ListNode;

public class No206 {

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode();
        while (head != null) {
            ListNode p = head.next;
            head.next = dummyHead.next;
            dummyHead.next = head;
            head = p;
        }
        return dummyHead.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseListRecur(ListNode head) {
        // 将最后一个节点作为头结点返回
        if (head == null || head.next == null) {
            return head;
        }
        // 后序遍历，先处理子节点
        ListNode p = reverseList(head.next);
        // 反转节点
        head.next.next = head;
        // 注意要将原链表的头结点的指针置空
        head.next = null;
        return p;
    }

}
