package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class a3 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char c1 = s.charAt(right);
            window.merge(c1, 1, (p, o) -> p + o);
            right++;

            while (window.get(c1) > 1) {
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2) - 1);
                left++;
            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}
