package linkedlist;

import datastructure.ListNode;

public class No160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;
        /*
        当两个指针到达链表末尾时，令它们指向链表另一条链表的头部，
        如果两条链表有交点的话，最终两个指针会指向同一个节点，而这个节点就是相交的节点（因为长度抵消了，两个节点走的路程一样长）；
        如果没有交点的话，最终两个指针会同时为null
        */
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

}
