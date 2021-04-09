package datastructure;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer, DLinkNode> map;
    DLinkNode head;
    DLinkNode tail;
    int capacity;
    int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        this.head.next = this.tail;
        this.tail.pre = this.head;
        map = new HashMap<>();
    }

    public int get(int key) {
        DLinkNode node = map.getOrDefault(key, null);
        if (node != null) {
            ++node.count;
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }
        DLinkNode node = map.getOrDefault(key, null);
        if (node != null) {
            // 节点不为空则更新节点值
            ++node.count;
            node.value = value;
            map.put(key, node);
            moveToHead(node);
        } else {
            // 判断增加节点后是否大于容量
            if (size == capacity) {
                DLinkNode toDel = findNodeToDel();
                if (toDel != null) {
                    map.remove(toDel.key);
                    delNode(toDel);
                }
            } else {
                ++size;
            }
            // 节点为空则新建节点
            node = new DLinkNode(key, value);
            map.put(key, node);
            addToHead(node);
        }
    }

    private void addToHead(DLinkNode node) {
        node.next = this.head.next;
        this.head.next = node;
        node.pre = this.head;
        node.next.pre = node;
    }

    private void delNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkNode node) {
        delNode(node);
        addToHead(node);
    }

    private DLinkNode findNodeToDel() {
        int min = Integer.MAX_VALUE;
        // 从后往前搜索，删除最不经常使用节点中最久未使用的键
        DLinkNode node = null, p = tail.pre;
        while (p != head) {
            if (p.count < min) {
                node = p;
                min = p.count;
            }
            p = p.pre;
        }
        return node;
    }

    class DLinkNode {
        int key;
        int value;
        // 使用次数
        int count;
        DLinkNode next;
        DLinkNode pre;

        DLinkNode() {}

        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

}
