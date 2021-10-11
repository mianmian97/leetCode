package solution2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (Objects.nonNull(node)) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            node = node.next;
        }
        map.forEach((key, value) -> {
            value.next = map.get(key.next);
            value.random = map.get(key.random);
        });
        return map.get(head);
    }
}
