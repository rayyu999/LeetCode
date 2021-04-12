package linkedlist;

import datastructure.ListNode;

public class No92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 0;
        ListNode dummy = new ListNode(), p = dummy, l = null, r = null;
        dummy.next = head;
        while (p != null) {
            if (cnt == left - 1) {
                l = p;
            }
            if (cnt == right) {
                r = p;
                break;
            }
            p = p.next;
            ++cnt;
        }
        if (r != null && l.next != null) {
            l.next = reverse(l.next, r.next);
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(), cur = left, next;
        // 将当前子链表与原来链表不用反转的剩余部分连接起来
        dummy.next = right;
        while (cur != right) {
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        // 返回反转后的子链表头结点，方便拼接操作
        return dummy.next;
    }

}
