package HashList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/23/11:53
 * @Description:
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }


    }

    Map<Integer, DLinkedNode> cache = new HashMap<>();
    int size;
    int capacity;
    DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头结点和尾结点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newnode = new DLinkedNode(key, value);
            cache.put(key, newnode);
            addToHead(newnode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        //先删除节点
        removeNode(node);
        addToHead(node);
    }
}
