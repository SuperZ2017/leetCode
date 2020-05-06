package Sliding_Window;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长不含重复的子字符串
 *
 * pwwkew  wke
 */
public class b48 {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> windows = new HashSet<>();
        char[] ch = s.toCharArray();
        int maxLen = 0;
        int left = 0,right = 0;
        while (right <= ch.length - 1) {
            char c = ch[right];
            if (!windows.contains(c)) {
                windows.add(c);
                maxLen = Math.max(right - left + 1, maxLen);

            } else if (windows.contains(c)) {
                // 窗口右移，直到不包含这个元素
                while (windows.contains(c))
                    windows.remove(ch[left++]);
                windows.add(c);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
