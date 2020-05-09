package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-05-09 08:51
 */
public class CheckInclusion {

    public static void main(String[] args){

        System.out.println(checkInclusion("abc","bcba"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int[] map1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] map2 = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                map2[s2.charAt(i + j) - 'a']++;
            }
            if (check(map1, map2)) return true;
        }

        return false;
    }

    public static boolean check(int[] map1, int[] map2) {
        for (int i = 0; i < map1.length && i < map2.length; i++) {
            if (map1[i] != map2[i]) return false;
        }

        return true;
    }
}
