package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhangyi
 * @Date : 2020-03-28 20:28
 * <p>
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 */
public class MinimumLengthEncoding {

    public static void main(String[] args) {

        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    public static int minimumLengthEncoding(String[] words) {

        /*Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = word.length(); i > 0; i--) {
                set.remove(word.substring(i));
            }
        }

        int length = 0;
        for (String word : set) {
            length += word.length() + 1;
        }

        return length;*/

        //字典树法
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> map = new HashMap<>();

        for (int k = 0; k < words.length; k++) {
            TrieNode cur = trie;
            for (int i = words[k].length() - 1; i >= 0; i--) {
                cur = cur.get(words[k].charAt(i));
            }
            map.put(cur, k);
        }

        int length = 0;
        for (Map.Entry<TrieNode, Integer> entry : map.entrySet()) {
            if(entry.getKey().count == 0) {
                length += words[entry.getValue()].length() + 1;
            }
        }
        return length;
    }

    static class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }

            return children[c - 'a'];
        }
    }


}
