package recursion;

import datastructure.ListNode;

public class No23 {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        // 区间只有一条链表时直接返回
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        // 否则分治，拆分成多个配对然后合并
        return mergeLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private ListNode mergeLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(), p = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        if (a != null) {
            p.next = a;
        } else {
            p.next = b;
        }
        return dummy.next;
    }

}
