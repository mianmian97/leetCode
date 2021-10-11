package solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReversePrint {

    public static int[] reversePrint(ListNode head) {

        List<Integer> result = new ArrayList<>();
        recur(head, result);
        int[] array = new int[result.size()];
        for(int i = 0;i < result.size();i++){
            array[i] = result.get(i);
        }
        return array;
    }

    public static void recur(ListNode node, List<Integer> list) {
        if (Objects.isNull(node)) {
            return;
        }
        recur(node.next, list);
        list.add(node.val);
    }
}
