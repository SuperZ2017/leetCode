package jianzhioffer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
