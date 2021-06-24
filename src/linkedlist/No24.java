package linkedlist;

import datastructure.ListNode;

/**
 * @Author Ray
 * @Date 2021/6/24 22:54
 * @Description 24.两两交换链表中的节点
 */
public class No24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        // 当后面还有两个或以上的节点时才继续循环
        while (p.next != null && p.next.next != null) {
            // q每次都指向排序好的子链表的最后一个节点
            // p为两个节点中在后面的节点
            ListNode q = p.next.next;
            // 将第一个节点的next指向q的next
            p.next.next = q.next;
            // 将q的next指向第一个节点
            q.next = p.next;
            // 将q放在p的后面，完成交换
            p.next = q;
            // 排序好后，将p继续指向排序好的最后一个节点
            p = q.next;
        }
        return dummy.next;
    }

}
