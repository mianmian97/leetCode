package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : zhangyi
 * @Date : 2020-05-10 12:02
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        RestoreIpAddresses ipAddresses = new RestoreIpAddresses();
        System.out.println(ipAddresses.restoreIpAddresses("25525511135"));
    }

    int n;
    String ip;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        n = s.length();
        ip = s;
        return foundBack(-1, 3);
    }

    List<String> foundBack(int preIndex, int aegmentNum) {

        int endIndex = Math.min(n - 1, preIndex + 4);
        for (int currIndex = preIndex + 1; currIndex < endIndex; currIndex++) {
            String segment = ip.substring(preIndex + 1, currIndex + 1);
            if (check(segment)) {
                segments.add(segment);
                if (aegmentNum != 1) {
                    foundBack(currIndex, aegmentNum - 1);
                } else {
                    save(currIndex);
                }
                segments.removeLast();
            }
        }

        return result;
    }

    void save(int preIndex) {
        String segment = ip.substring(preIndex + 1, n);
        if (check(segment)) {
            segments.add(segment);
            result.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    boolean check(String segment) {

        if (segment.length() > 3) return false;
        return segment.charAt(0) == '0' ? segment.length() == 1 : Integer.valueOf(segment) <= 255;
    }
}
