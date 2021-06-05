package linkedlist;

import datastructure.ListNode;

/**
 * @Author Ray
 * @Date 2021/6/5 11:17
 * @Description 203.移除链表元素
 */
public class No203 {

    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements_recur(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements_recur(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 迭代
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(), p = dummy;
        while (head != null) {
            if (head.val != val) {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        p.next = null;
        return dummy.next;
    }

}
