package solution2;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("absbdb", 3));
    }

    public static String reverseLeftWords(String s, int n) {

        String right = s.substring(0, n);
        String left = s.substring(n);
        return left + right;
    }
}
