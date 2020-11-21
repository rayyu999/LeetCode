package linkedlist;

import datastructure.ListNode;

public class No148 {

    public ListNode sortList(ListNode head) {
        return head == null ? head : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        // 递归边界为拆分的链表只有单个节点
        if (head.next == null) {
            return head;
        }

        // 快慢指针将链表拆成两半, p指针找到后半段链表的首结点
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            // pre指针来方便将链表拆成两半
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;

        // 递归对链表进行排序
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 对两个链表进行归并
        while (l != null && r != null) {
            if (l.val < r. val) {
                cur.next = l;
                cur = l;
                l = l.next;
            } else {
                cur.next = r;
                cur = r;
                r = r.next;
            }
        }
        // 因为两个链表分别都是排序好的，因此不需要用while
        if (l != null) cur.next = l;
        if (r != null) cur.next = r;
        return dummy.next;
    }

}
