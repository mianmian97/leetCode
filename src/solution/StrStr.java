/**
 * @(#)StrStr.java, 9月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution;

import com.sun.tools.javac.util.StringUtils;

import java.util.Objects;

/**
 * @Author: Zhang Yi
 * @Date: 2020/9/12 12:23 下午
 */
public class StrStr {

    public static void main(String[] args) {

        System.out.println(strStr("a", "a"));
    }

    public static int strStr(String haystack, String needle) {

        if (Objects.isNull(needle) || "".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int hayIndex = 0;
        while (hayIndex < haystack.length()) {
            if (haystack.charAt(hayIndex) == needle.charAt(0) && hayIndex + needle.length() <= haystack.length()) {
                String substring = haystack.substring(hayIndex, hayIndex + needle.length());
                if (substring.equals(needle)) {
                    return hayIndex;
                }
            }
            hayIndex++;
        }
        return -1;
    }
}