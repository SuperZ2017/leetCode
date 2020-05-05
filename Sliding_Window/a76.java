package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class a76 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            needs.merge(t.charAt(i), 1, (prev ,one) -> prev + one);

        int left = 0, right = 0, start = 0;
        int match = 0;
        int minlen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.merge(c1, 1, (p, o) -> p + o);
                if (window.get(c1).compareTo(needs.get(c1)) == 0)
                    match++;
            }

            right++;

            // 满足要求
            while (match == needs.size()) {
                if (right - left < minlen) {
                    start = left;
                    minlen = right - left;
                }

                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2)-1);
                    if (window.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }
        }

        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, minlen + start);
    }


}
