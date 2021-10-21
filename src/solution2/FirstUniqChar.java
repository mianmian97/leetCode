package solution2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {

        Map<Character, Boolean> map = new LinkedHashMap<>(s.length());
        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if (!map.get(c)) return c;
        }
        return ' ';
    }
}
