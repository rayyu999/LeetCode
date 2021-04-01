package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode No.146
 */
public class LRUCache {

    private DLinkNode head;
    private DLinkNode tail;
    private Map<Integer, DLinkNode> map;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 先通过哈希表获取链表节点
        DLinkNode node = map.getOrDefault(key, null);
        // 获取不到直接返回-1
        if (node == null) {
            return -1;
        }
        // 获取到则将对应节点移动到链表头部
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        // 先通过哈希表获取链表节点
        DLinkNode node = map.getOrDefault(key, null);
        // 获取不到则直接加入新节点
        if (node == null) {
            ++size;
            node = new DLinkNode(key, value);
            addToHead(node);
            // 加入后队列大小超过容量，将队尾节点删除
            if (size > capacity) {
                delNode(tail.pre);
                --size;
            }
        } else {
            // 获取到则更新节点的值，并将其移动到队头
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkNode node) {
        // 将节点添加到队列头部
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
        // 将节点添加进哈希表中
        this.map.put(node.key, node);
    }

    private void delNode(DLinkNode node) {
        // 删除节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // 同时也要在哈希表中删除
        this.map.remove(node.key);
    }

    private void moveToHead(DLinkNode node) {
        // 先在队列中删除节点
        delNode(node);
        // 再移动到队头
        addToHead(node);
    }

    static class DLinkNode {
        // 双向链表实现
        DLinkNode next;
        DLinkNode pre;
        int key;
        int val;

        DLinkNode(int _key, int _value) {
            this.key = _key;
            this.val = _value;
        }

        DLinkNode() {}

    }

}
