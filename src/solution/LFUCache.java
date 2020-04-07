package solution;

import java.util.*;

/**
 * @Author : zhangyi
 * @Date : 2020-04-06 22:33
 * <p>
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 * <p>
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近 最少使用的键。
 * <p>
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 */
public class LFUCache {

    private int capacity;
    private Queue<Integer> queue;
    private Map<Integer, Integer> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        queue = new PriorityQueue<>();
        map = new HashMap<>(capacity);
    }

    public int get(int key) {

        Integer val = map.get(key);
        if (Objects.nonNull(val)) {
            queue.offer(key);
            return val;
        }
        return -1;

    }

    public void put(int key, int value) {

    }
}
