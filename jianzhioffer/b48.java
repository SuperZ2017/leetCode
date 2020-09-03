package jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 */
public class b48 {

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        char[] ch = s.toCharArray();
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!window.contains(c)) {
                window.add(c);
                maxLen = Math.max(right - left + 1, maxLen);
            } else if (window.contains(c)) {
                while (window.contains(c)) {
                    window.remove(ch[left]);
                    left++;
                }
                window.add(c);
            }

            right++;
        }
        return maxLen;

    }

}
