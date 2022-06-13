package Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 */
public class a438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0, match = 0;

        for (int i = 0; i < p.length(); i++)
            needs.merge(p.charAt(i), 1, (prev, one) -> prev + one);

        while (right < s.length()) {

            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                windows.merge(c1, 1, (prev, one) -> prev + one);
                if (windows.get(c1).compareTo(needs.get(c1)) == 0)
                    match++;
            }
            right++;

            // 注意 needs 与 p 的长度不一样
            while (match == needs.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }

                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    windows.put(c2, windows.get(c2) - 1);
                    if (windows.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }

        }
        return res;
    }
}
