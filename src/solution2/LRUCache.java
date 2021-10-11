package solution2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }

    class MLinkedNode {

        int key;
        int value;
        MLinkedNode pre;
        MLinkedNode next;

        public MLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public MLinkedNode() {
        }
    }

    private int size;

    private int capacity;

    private MLinkedNode head, tail;

    private Map<Integer, MLinkedNode> map = new HashMap<>();

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.size = 0;
        head = new MLinkedNode();
        tail = new MLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        MLinkedNode mLinkedNode = map.get(key);
        if (Objects.isNull(mLinkedNode)) {
            return -1;
        }
        moveHead(mLinkedNode);
        System.out.println(mLinkedNode.value);
        return mLinkedNode.value;
    }

    public void put(int key, int value) {

        MLinkedNode mLinkedNode = map.get(key);
        if (Objects.nonNull(mLinkedNode)) {
            mLinkedNode.value = value;
            moveHead(mLinkedNode);
            return;
        }

        MLinkedNode node = new MLinkedNode(key, value);
        map.put(key, node);
        addHead(node);
        size++;
        if (size > capacity) {
            MLinkedNode tail = removeTail();
            map.remove(tail.key);
            size--;
        }

    }

    private void addHead(MLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(MLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveHead(MLinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private MLinkedNode removeTail() {
        MLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }
}
