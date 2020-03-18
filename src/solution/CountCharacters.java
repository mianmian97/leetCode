package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-17 18:47
 * <p>
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
public class CountCharacters {

    public static void main(String[] args) {

        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {

        /*char[] charsArr = chars.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char c : charsArr) {
            charList.add(c);
        }

        int count = 0;
        for (String word : words) {
            List<Character> c = new ArrayList<>(charList);
            for (int i = 0; i < word.length(); i++) {
                if (word.length() > chars.length() || !c.contains(word.charAt(i))) {
                    break;
                }
                if (i == word.length() - 1) {
                    count += word.length();
                } else {
                    c.remove(Character.valueOf(word.charAt(i)));
                }
            }
        }
        return count;*/

        int count = 0;
        int[] charsArr = getCount(chars);
        for (String word : words) {
            if (contant(getCount(word), charsArr)) count += word.length();
        }
        return count;
    }

    private static boolean contant(int[] word, int[] chars) {
        for (int i = 0; i < 26; i++) {
            if (word[i] > chars[i]) return false;
        }
        return true;
    }

    private static int[] getCount(String word) {

        int[] countArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            countArr[word.charAt(i) - 'a']++;
        }
        return countArr;
    }
}
