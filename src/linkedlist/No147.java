package linkedlist;

import datastructure.ListNode;

public class No147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode last = head, dummy = new ListNode(0);
        dummy.next = head;
        head = head.next;	// 将第一个节点看作已排序好的链表，从第二个节点开始处理
        while (head != null) {
            last.next = head.next;     // 断开当前处理节点与其左右节点的连接
            ListNode pos = dummy;

            // 插入的位置为排好序链表中第一个比p的值大的节点前面
            while (pos != last && pos.next.val < head.val) pos = pos.next;

            head.next = pos.next;
            pos.next = head;

            if (pos == last) last = head;	// last总是指向排好序链表的最后一个节点
            head = last.next;  // 继续处理剩余未排序节点
        }
        return dummy.next;
    }

}
