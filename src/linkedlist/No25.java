package linkedlist;

import datastructure.ListNode;

public class No25 {

    /**
     * 三指针
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup_TriPointer(ListNode head, int k) {
        // pre节点每次都指向当前处理的子链表的头结点的上一个节点，即其next指针指向当前子链表的头结点
        ListNode dummy = new ListNode(), pre = dummy, cur = head, next;
        dummy.next = head;
        // 统计链表长度
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        // 开始按组翻转链表
        for (int i = 0; i < len / k; ++i) {
            // 不断将cur节点的next节点插入到头部，因此只需要操作k-1次
            for (int j = 0; j < k - 1; ++j) {
                // 记录当前节点的下一个节点
                next = cur.next;
                // 将当前节点往后移动一个位置
                cur.next = next.next;
                // 将next节点插入到当前子链表的头部
                next.next = pre.next;
                pre.next = next;
            }
            // 操作完成后cur节点会到当前子链表的尾部
            pre = cur;
            // 将cur指向下一个子链表的头部
            cur = pre.next;
        }
        return dummy.next;
    }

    /**
     * 模拟
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup_Simulation(ListNode head, int k) {
        ListNode dummy = new ListNode(), cur = head, pre = dummy;
        dummy.next = head;
        while (cur != null) {
            ListNode last = cur;
            // 找当前待处理子链表的区间
            int cnt = 0;
            while (cur != null && cnt < k) {
                ++cnt;
                cur = cur.next;
            }
            // 不足k个节点，跳出循环
            if (cnt < k) {
                break;
            }
            reverseLinkedList(pre, cur);
            pre = last;
        }
        return dummy.next;
    }

    /**
     * 翻转子链表
     * @param lastTail 上一个子链表的尾节点
     * @param nextList 下一个子链表的头结点
     */
    private void reverseLinkedList(ListNode lastTail, ListNode nextList) {
        ListNode dummy = new ListNode(), head = lastTail.next, next;
        // 首先把dummy.next指向下一个子链表的头结点
        dummy.next = nextList;
        // 头插法
        while (head != null && head != nextList) {
            next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        // 链接上一个子链表和当前子链表
        lastTail.next = dummy.next;
    }

}
