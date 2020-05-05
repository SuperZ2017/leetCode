package Sliding_Window;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 */
public class a567 {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        char[] ch1 = s1.toCharArray();  // "ab";
        char[] ch2 = s2.toCharArray();  // "eidbaooo";
        int len = ch2.length - 1;
        int left = 0, right = 0, start = 0, match = 0;
        for (char c : ch1)
            needs.merge(c, 1, (p, o) -> p + o);

        while (right <= len ) {
            char c1 = ch2[right];
            right++;
            if (needs.containsKey(c1)) {
                windows.merge(c1, 1, (p, o) -> p + o);
                if (windows.get(c1).compareTo(needs.get(c1)) == 0)
                    match++;
            }

            while (right - left >= s1.length()) {
                if (match == needs.size())
                    return true;
                char c2 = ch2[left];
                left++;
                if (needs.containsKey(c2)) {
                    if (windows.get(c2) == needs.get(c2))
                        match--;
                    windows.put(c2, windows.get(c2) - 1);
                }
            }
        }

        return false;
    }
}
